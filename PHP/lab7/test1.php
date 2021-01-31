<?php
session_start();
include_once('classes/User.php');

echo "Id sesji= ".session_id()."<br/>";

$user1 = new User("Przykład", "shhshshs","Jan Przykładzki","jprzyklad@wp.pl");
echo "<p> Dane użytkownika:  <br />";
$user1->show();

echo "</p>";
echo "<p>Serializacja użytkownika: <br />".serialize($user1).
    " </p>";

$_SESSION['user'] = serialize($user1);

echo session_name()." - ".$_COOKIE[session_name()]."<br/>";

echo '<a href="http://localhost/lab7/test2.php">Test 2</a>';
