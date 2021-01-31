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
                    <option value="Nimecy">Niemcy</option>
                    <option value="Wielka Brytania">Wielka Brytania</option>
                    <option value="Czechy">Czechy</option>
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
            <label for="PHP">
                <input type="checkbox" name="jezyki[]" value="PHP"> PHP
            </label>
            <label for="CPP">
                <input type="checkbox" name="jezyki[]" value="CPP"> C++
            </label>
            <label for="Java">
                <input type="checkbox" name="jezyki[]" value="Java"> Java
            </label>
        </p>

        <p>
            <strong>Sposób zapłaty: </strong>
            <label>
                <input type="radio" name="sposob_zaplaty" value="Visa"> Visa
            </label>
            <label>
                <input type="radio" name="sposob_zaplaty" value="Master Card"> Master Card
            </label>
            <label>
                <input type="radio" name="sposob_zaplaty" value="Przelew"> Przelew bankowy
            </label>
        </p>

        <p>
            <label for="id_do_usuneicia">
                Podaj który id chcesz usunać z bazy: <input type="number" name="id">
            </label>
        </p>

        <p>
            <input type="reset" value="Anuluj">
            <input type="submit" name="submit" value="Dodaj">
            <input type="submit" name="submit" value="Pokaż">
            <input type="submit" name="submit" value="Usuń">
            <input type="submit" name="submit" value="PHP">
            <input type="submit" name="submit" value="C++">
            <input type="submit" name="submit" value="Java">

        </p>
    </form>

    <?php
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
    $errors = "";
    foreach($dane as $key => $val){
        if($val === false or $val === NULL){
            $errors.= $key." ";
        }
    }

    if ($errors === ""){
   return $dane;
    }
    else{
        echo "Nie poprawne dane:". $errors;
        return false;
    }

}


function dodajdoBD($bd){

    $dane = walidacja();

    if($dane){
        $sql = "INSERT INTO klienci (Nazwisko,Wiek,Panstwo,Email,Zamowienie,Platnosc) VALUES ('".$dane['nazwisko']."','".$dane['wiek']."','".$dane['panstwo']."','".$dane['email']."','".join($dane['jezyki'],',')."','".$dane['sposob_zaplaty']."')";
        echo "Dane dodawanego rekordu: </br>".$sql;
        $bd->insert($sql);
    }

}

function usunzBD($bd){
    $id = filter_input(INPUT_POST, "id");
    $sql = "DELETE FROM klienci WHERE Id ='".$id."'";

    $bd->delete($sql);
}



