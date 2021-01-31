<?php
function drukuj_form(){ ?>
<form action="formularz.php" method="POST">

    <p>
        <label for="nazwisko">
            Nazwisko:
            <input type="text" name="nazwisko">
        </label>
    </p>

    <p>
        <label for="wiek">
            Wiek:
            <input type="number" name="wiek">
        </label>
    </p>

    <p>
        <label for="nazwisko">
            Państwo:
            <select name="panstwo">
                <option value="Polska">Polska</option>
                <option value="Anglia">Anglia</option>
            </select>
        </label>
    </p>

    <p>
        <label for="email">
            Email:
            <input type="email" name="email">
        </label>
    </p>

    <p>
        <strong>Zamawiam tutorial z języka: </strong>
        <label for="php">
            <input type="checkbox" name="jezyki[]" value="php"> PHP
        </label>
        <label for="c_cpp">
            <input type="checkbox" name="jezyki[]" value="c_cpp"> C/C++
        </label>
        <label for="java">
            <input type="checkbox" name="jezyki[]" value="java"> Java
        </label>
    </p>

    <p>
        <strong>Sposób zapłaty: </strong>
        <label>
            <input type="radio" name="sposob_zaplaty" value="eurocard"> eurocard
        </label>
        <label>
            <input type="radio" name="sposob_zaplaty" value="visa"> visa
        </label>
        <label>
            <input type="radio" name="sposob_zaplaty" value="przelew bankowy"> przelew bankowy
        </label>
    </p>

    <p>
        <input type="reset" value="Anuluj">
        <input type="submit" name="submit" value="Dodaj">
        <input type="submit" name="submit" value="Pokaż">
        <input type="submit" name="submit" value="Pokaż statystyki">
        <input type="submit" name="submit" value="PHP">
        <input type="submit" name="submit" value="C++/C">
        <input type="submit" name="submit" value="Java">

    </p>
</form>

<?php
}


function dodaj()
{


        walidacja();


}

function dopliku($plik, $tablicazdanymi){

    $dane="";
    $dane.=PHP_EOL;
    foreach($tablicazdanymi as $key => $val){
        if(is_array($val)){
            $dane.= join($val)." ";
        }
        else
       $dane.= $val .' ';

    }

    $wp = fopen($plik, "a");
    fwrite($wp, $dane);
    fclose($wp);

}

function pokaz(){

    $d_root = $_SERVER['DOCUMENT_ROOT'];
    $tresc = fopen("$d_root/../NowaLokalizacja/dane.txt","r");
    while(!feof($tresc)) {
        echo fgets($tresc). "<br />";
    }
    fclose($tresc);
}

function pokaz_zam($lang){

    $d_root = $_SERVER['DOCUMENT_ROOT'];
    $zam = file("$d_root/../NowaLokalizacja/dane.txt");
    foreach($zam as $key){
        if(strpos($key, $lang) !== FALSE) {
            echo $key."<br/>";
        }
    }

}

function walidacja(){
    $arg = array(
            'nazwisko' => ['filter'=> FILTER_VALIDATE_REGEXP,
                            'options' => ['regexp' => '/^[A-Z]{1}[a-ząęłńśćźżó-]{1,25}$/']],

            'wiek' => ['filter' => FILTER_VALIDATE_INT,
                        'options' => ['min_range' => 15, 'max_range' => 100]],

            'panstwo' => FILTER_SANITIZE_FULL_SPECIAL_CHARS,

            'email' => FILTER_SANITIZE_EMAIL,

            'jezyki' =>['filter' => FILTER_SANITIZE_FULL_SPECIAL_CHARS,
                            'flags' => FILTER_REQUIRE_ARRAY],

            'sposob_zaplaty' => FILTER_SANITIZE_FULL_SPECIAL_CHARS


    );

    $dane = filter_input_array(INPUT_POST, $arg);
    var_dump($dane);
    $errors = "";
    foreach($dane as $key => $val){
        if($val === false or $val === NULL){
            $errors.= $key." ";
        }
    }

    if ($errors === ""){
        $d_root = $_SERVER['DOCUMENT_ROOT'];
        dopliku("$d_root/../NowaLokalizacja/dane.txt", $dane);
    }
    else{
        echo "Nie poprawne dane:". $errors;
    }

}

function pokaz_stat(){

    $ilosc_zamowien = 0;
    $przedzial_pierwszy=0;
    $przedzial_srodkowy=0;
    $przedzial_koncowy=0;

    $d_root = $_SERVER['DOCUMENT_ROOT'];
    $zam = file("$d_root/../NowaLokalizacja/dane.txt");
    foreach($zam as $key){
        $ilosc_zamowien++;
       $detale = explode(" ", $key);
             if($detale[1] <= 18){
                $przedzial_pierwszy++;
                 }
             if( $detale[1] > 18 && $detale[1] < 50){
                $przedzial_srodkowy++;
                 }
             if($detale[1] >= 50){
                $przedzial_koncowy++;
                }
        }
    echo"<h2> Statystki zakupów </h2>";
    echo"Ilość zakupionych kursów w sumie:".$ilosc_zamowien."</br>";
    echo"Ilosc osob w wieku 18 lat lub młodszych, które zakupiły kurs:".$przedzial_pierwszy."</br>";
    echo"Ilosc osob starszych niż 18 lat ale młodszych niż 50, które zakupiły kurs:".$przedzial_srodkowy."</br>";
    echo"Ilosc osob w wieku 50 lat lub starszych, które zakupiły kurs:".$przedzial_koncowy."</br>";
    }





