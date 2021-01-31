<?php


class Baza
{
    private $mysql;
    public function __construct($serwer, $user, $password,$baza){
        $this->mysql = new mysqli($serwer,$user,$password,$baza);

        if($this->mysql->connect_errno){
            printf("Łączenie z serwerem nie powiodło się: %s\n", $this->mysql->connect_error);
            exit();
        }

        if($this->mysql->set_charset("utf8")){
            echo "Udało się zmienić kodowanie".PHP_EOL;
        }

    }

    function __destruct(){
        $this->mysql->close();
    }

    public function select($sql, $pola){
        $tresc="";
        if($result = $this->mysql->query($sql)){
            $kolumny=count($pola);
            $rekordy=$result->num_rows;

            $tresc.="<table border='2px' ><tbody>";

            while($rekordy = $result->fetch_object()){
                $tresc.="<tr>";
                for($i=0; $i<$kolumny; $i++){
                    $p=$pola[$i];
                    $tresc.="<td>".$rekordy->$p."</td>";
                }
                $tresc.="</tr>";
            }
            $tresc.="</tbody></table>";
            $result->close();

        }
        return $tresc;
    }

    public function insert($sql){
        if($this->mysql->query($sql)){
            echo PHP_EOL."Dodano do bazy";
            return true;
        }
        else {
           echo "Dodanie nie powiodło się";
            return false;
        }
    }

    /**
     * @return mysqli
     */
    public function getMysql()
    {
        return $this->mysql;
    }


    public function delete($sql){
        if($this->mysql->query($sql)){
            echo PHP_EOL."Usunieto";
            return true;
        }
        else {
            echo PHP_EOL."Usuwanie nie powiodło się";
            return false;
        }
    }

}