<?php
include_once 'Klasy/User.php';
include_once 'Klasy/RegistrationForm.php';
include_once 'Klasy/Baza.php';


$form = new RegistrationForm();

//$user1 = new User('Staś', 'pieniadze', 'Stanisław Wokulski', 'stas@gmail.com' );
//$user2 = new User('AR', 'epidemia', 'Andre Rieux', 'a.rieux@onet.pl');

//$user1->show();
//$user2->show();

//$user2->setUserName('ADMIN');
//$user2->setPassword('admin');
//$user2->setStatus(2);

//$user2->show();

$bd=new Baza("localhost", "root","918273", "klienci");


if(filter_input(INPUT_POST, "submit")){
    $act = filter_input(INPUT_POST,"submit");
    switch($act) {
        case "Rejestruj":
            if (filter_input(INPUT_POST, 'submit', FILTER_SANITIZE_FULL_SPECIAL_CHARS)) {
                $user3 = $form->chceckUser();
                if ($user3 === NULL) {
                    echo '<p> Niepoprawne dane rejestracji </p>';
                } else {
                    echo '<p> Poprawne dane rejestracji </p>';
                    $user3->dodajdoBD($bd);
                    echo $bd->select("SELECT * FROM klienci", array("Id","Nazwisko","Wiek","Panstwo","Email","Zamowienie","Platnosc",));
                }
                break;
                //case "Pokaż": ; break;
            }


    }
}



//User::getAllUsers('user.json');