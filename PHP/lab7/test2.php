<?php
session_start();
include_once('classes/User.php');

echo "Id sesji= ".session_id()."<br/>";

if(isset($_SESSION['user'])){
        $user2 = $_SESSION['user'];
        echo "<p>Użutkownik user 1 z sesji: <br />" .
             $user2. " </p>";

        $user1= unserialize($_SESSION['user']);
        echo "<p>Dane użtykownika po odzyskaniu: <br/>";
        $user1->show();
        echo "</p>";
        }
else echo "Brak obiektów w sesji";

if ( isset($_COOKIE[session_name()]) ) {
    setcookie(session_name(),'', time() - 42000, '/');
}
session_destroy();


echo '<a href="http://localhost/lab7/test1.php">Test 1</a>';