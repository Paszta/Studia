<?php


class RegistrationForm
{
    protected $user;

    /**
     * RegistrationForm constructor.
     */
    public function __construct()
    {
        ?>
        <h1>Formularz rejestracji: </h1>
        <form action="index.php" method="POST">
            <table>
                <tbody>
                <tr>
                    <td>Nazwa użytkownika : </td>
                    <td> <input type="text" name="userName"/> </td>
                </tr>
                <tr>
                    <td>Imię i nazwisko : </td>
                    <td><input type="text" name="fullName" /></td>
                </tr>
                <tr>
                    <td>Hasło :</td>
                    <td><input type="password" name="passwd" /></td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><input type="email" name="email" /></td>
                </tr>
                </tbody>
            </table>

            <input type="reset" value="Wyczyść" />
            <input type="submit" name="submit" value="Rejestruj" />
            <input type="submit" name="submit" value="Pokaż" />
            <a href="http://localhost/lab7/test1.php">Test 1</a>
        </form>
        <?php
    }

    public function checkUser(){
        $args = array(
            "userName" =>['filter' => FILTER_VALIDATE_REGEXP,
                'options' => ['regexp' => '/^[0-9A-Za-ząęłńśćźżó_-]{2,25}$/']
            ],
            "fullName" =>['filter' => FILTER_VALIDATE_REGEXP,
                'options' => ['regexp' => '/^[A-ZŁĄŹŻĆĄŚ][a-zążśźćł]{2,15}\s[A-ZŁĄŹŻĆĄŚ][a-zążśźćł]{2,15}-?([A-ZŁĄŹŻĆĄŚ][a-zążśźćł]{2,15}|)$/']
            ],
            "passwd" => FILTER_SANITIZE_FULL_SPECIAL_CHARS,
            "email" => FILTER_VALIDATE_EMAIL,
        );
        $data = filter_input_array(INPUT_POST, $args);
        $errors = "";
        foreach ($data as $key => $val){
            if($val === false or $val === NULL){
                $errors .= $key." ";
            }
        }
        if($errors === ""){
            $this->user = new User($data['userName'], $data['passwd'], $data['fullName'], $data['email']);
        }
        else{
            echo "<br> Niepoprawne dane: ". $errors;
            $this->user = NULL;
        }
        return $this->user;
    }
}