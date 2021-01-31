<?php


class Baza {
    private $mysql;
    public function __construct($serwer, $user, $password,$baza){
        $this->mysql = new mysqli($serwer,$user,$password,$baza);

        if($this->mysql->connect_errno){
            printf("Łączenie z serwerem nie powiodło się: %s\n", $this->mysql->connect_error);
            exit();
        }

        $this->mysql->set_charset("utf8");
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
    public function delete($sql){
        if($this->mysql->query($sql)){
           // echo PHP_EOL."Usunieto";
            return true;
        }
        else {
            echo PHP_EOL."Usuwanie nie powiodło się";
            return false;
        }
    }

    public function selectUser($login,$passwd,$tabela){
        $id=-1;

        $sql = "SELECT * FROM users WHERE userName ='$login'";

        if($result = $this->mysql->query($sql)){
            $counter=$result->num_rows;
            if($counter==1){
                $row = $result->fetch_object();
                $hash = $row->passwd;
                if(password_verify($passwd,$hash)) $id=$row->id;
            }
        }

        return $id;

    }

    public function selectLoggedInUser($sql){
        if($result = $this->mysql->query($sql)) {
            $counter = $result->num_rows;
            if($counter ==1){
                $row = $result->fetch_object();

                return $row->userId ;
            }
            else return -1;
        }

    }

}

