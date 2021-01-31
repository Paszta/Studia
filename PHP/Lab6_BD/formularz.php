<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Formularz</title>
</head>
<body>

<?php
include_once "funkcje.php";
include_once "Klasy/Baza.php";

drukuj_form();

$bd=new Baza("localhost", "root","918273", "klienci");

if(filter_input(INPUT_POST, "submit")){
    $act = filter_input(INPUT_POST,"submit");
    switch($act){
        case "Dodaj": dodajdoBD($bd); break;
        case "Pokaż": echo $bd->select("SELECT * FROM klienci", array("Id","Nazwisko","Wiek","Panstwo","Email","Zamowienie","Platnosc",)); break;
        case "Usuń": usunzBD($bd); break;
        case "PHP": echo $bd -> select("SELECT * FROM klienci WHERE Zamowienie REGEXP('PHP') ", array("Nazwisko","Zamowienie")) ; break;
        case "C++": echo $bd -> select("SELECT * FROM klienci WHERE Zamowienie REGEXP('CPP') ", array("Nazwisko","Zamowienie")) ; break;
        case "Java": echo $bd -> select("SELECT * FROM klienci WHERE Zamowienie REGEXP('Java') ", array("Nazwisko","Zamowienie")) ; break;
    }
}



?>
</body>
</html>
