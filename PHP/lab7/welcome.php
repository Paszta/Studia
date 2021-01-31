<?php
include_once('classes/User.php');
include_once('classes/RegistrationForm.php');
include_once('classes/UserManager.php');
include_once ('classes/Baza.php');

session_start();
$um = New UserManager();
$db = new Baza("localhost", "root", "918273", "klienci");
$ul =  $um->getLoggedInUser($db,session_id());

if($ul > 0 ){
    echo "<h2> Zalogowano użytkownika o id= ". $ul."</h2><br/>";

    echo "<h3>Dane użytkownika: </h3>";

    $sql = "SELECT userName, fullName,email FROM users WHERE id='$ul'";
    echo $db->select($sql, array("userName","fullName","email"));


    echo '<a href="http://localhost/lab7/processlogin.php?akcja=Wyloguj">Wyloguj</a>';

}

else{
    header("Location: http://localhost/lab7/index.php");
}

