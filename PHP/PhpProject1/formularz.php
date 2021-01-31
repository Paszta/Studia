<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Formularz</title>
</head>
<body>

<?php
include_once "funkcje.php";

drukuj_form();
if(filter_input(INPUT_POST, "submit")){
    $act = filter_input(INPUT_POST,"submit");
    switch($act){
        case "Dodaj": dodaj(); break;
        case "Pokaż": pokaz(); break;
        case "Pokaż statystyki": pokaz_stat(); break;
        case "PHP": pokaz_zam("php"); break;
        case "C++/C": pokaz_zam("c_cpp"); break;
        case "Java": pokaz_zam("java"); break;
    }
}

//echo "<h2> Dane z serwera </h2>";

//foreach($_SERVER as $key_name => $key_value) {

//    echo $key_name ."=". $key_value . "<br>";
//}


?>
</body>
</html>
