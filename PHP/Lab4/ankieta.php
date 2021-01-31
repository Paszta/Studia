<?php
echo "<h2>  Wybierz język:  </h2></br> ";

$tech = ["C", "CPP", "Java", "C#", "Html", "CSS", "XML", "PHP", "Javascript"];
$path = "ankieta.txt";
$ankieta = [];
?>
<form action="ankieta.php" method="POST">
<?php
foreach($tech as $key){

echo"<input type='checkbox' name ='tech[]' value=".$key."> ".$key. "</br>";
}

echo"<input type='submit' name='submit' value='Dodaj'>";

?>
</form>
    <?php


function dodaj(){
    global $path, $tech, $ankieta;

    if(!(file_exists($path))){
        $dane="";
        $plik = fopen($path,"a");
        foreach($tech as $key){
            $dane.=0;
            $dane.= PHP_EOL;
        }
        fwrite($plik, $dane);
        fclose($plik);
            }
    else
        echo"Plik został już stworzony! </br>";

    $wart = file($path, FILE_SKIP_EMPTY_LINES);


    foreach($tech as $key => $val){
        $ankieta[$val] = $wart[$key];
    }

    if(filter_input(INPUT_POST, "submit")){
        $produkty = filter_input(INPUT_POST, 'tech', FILTER_DEFAULT, FILTER_REQUIRE_ARRAY);
        foreach($produkty as $key){
            $ankieta[$key] = intval($ankieta[$key])+1;
            $ankieta[$key] = strval($ankieta[$key]).PHP_EOL;
        }


        $dane="";
        $plik = fopen($path,"w");
        foreach($ankieta as $key => $value){
            $dane.=$value;
        }
        fwrite($plik, $dane);
        fclose($plik);


        $tresc = fopen($path,"r");
        while(!feof($tresc)) {
            echo fgets($tresc). "<br />";
        }
        fclose($tresc);
        }

    }



if(filter_input(INPUT_POST, "submit")){
    dodaj();
}
?>