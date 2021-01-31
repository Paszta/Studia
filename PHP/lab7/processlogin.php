<?php
include_once('classes/UserManager.php');
include_once('classes/User.php');
include_once ('classes/Baza.php');


$um = new UserManager();
$um->loginForm();
$db = new Baza("localhost", "root", "918273", "klienci");
if (filter_input(INPUT_POST, "submit")){
       $userId =  $um->login($db);
       if($userId > 0){
           header("Location: http://localhost/lab7/welcome.php");
       }
       else echo "Nieprawidłowe dane użytkownika <br/>";
        $um->loginForm();

}

if(filter_input(INPUT_GET,"akcja") == "Wyloguj"){
    $um->logout($db);
}
session_start();
if($um->getLoggedInUser($db,session_id()) >=0){
    header("Location: http://localhost/lab7/welcome.php");
}


echo '<a href="http://localhost/lab7/index.php">Formularz rejestracji</a>';