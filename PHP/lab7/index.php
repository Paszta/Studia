<?php
include_once('classes/User.php');
include_once('classes/RegistrationForm.php');
include_once ('classes/Baza.php');
$rf = new RegistrationForm();
$db = new Baza("localhost", "root", "918273", "klienci");
if (filter_input(INPUT_POST, 'submit', FILTER_SANITIZE_FULL_SPECIAL_CHARS)) {
    $act = filter_input(INPUT_POST,"submit");
    switch($act) {
        case "Rejestruj":
                 $user = $rf->checkUser();
                 if ($user === NULL)
                 echo "<p>Niepoprawne dane rejestracji.</p>";
                 else {
                     echo "<p>Poprawne dane rejestracji:</p>";
                     $user->saveToDB($db);
                    }
                 break;
        case "Pokaż":
                 User::getAllUsersFromDB($db);
                 break;
                        }
    }

echo '<a href="http://localhost/lab7/processlogin.php">Formularz logowania</a>';

