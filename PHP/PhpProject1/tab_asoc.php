<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<?php

function wyswietl($tablica){
    foreach($tablica as $klucz => $imie){
        echo "$klucz"." - ".$imie."<br/>";
    }
};

echo"<h2>Studenci nieposortowani</h2>";

$studenci = array("1900"=>"Tadeusz Soplica", "1901"=>"Jacek Soplica", "1902"=>"Izabela Łęcka", "1903"=>"Stanisław Wokulski", "1904"=>"Ignacy Rzecki");
wyswietl($studenci);

echo"<h2>Studenci posortowani według klucza</h2>";

ksort($studenci);
wyswietl($studenci);

echo"<h2>Studenci posortowani alfabetycznie</h2>";

asort($studenci);
wyswietl($studenci);

echo"<h2>Studenci z dodanym Bernardem Rieuxem</h2>";

array_push($studenci,"Bernard Rieux");
wyswietl($studenci);

$studenci2 = array("1906" => "Charles Marlow", "1907" => "Maciej Boryna");

echo"<h2>Połączone tablice studentów</h2>";

wyswietl(array_merge($studenci,$studenci2));

?>
<h2> Tabela </h2>
    <?php
    shuffle($studenci);
    echo"<table border="."3".">";
    foreach($studenci as $klucz => $imie){
        echo"<tr>";
        echo "<td>"."$klucz"."</td>"."<td>".$imie."</td>";
        echo"</tr>";
    }
    echo"</table>";

    echo"</br>";

    $oceny = array("1900"=>array(3,5,6,3,2,1,5), "1901"=>array(2,2,4,3,2,2,2), "1902"=>array(5,5,5,5,3,4,4));

    foreach($oceny as $key => $value){
        $average=array_sum($value)/count($value);
        echo "$key"." - ".$average."<br/>";
    }
    ?>


</body>
</html>

