<?php

include_once 'User.php';

class RegistrationForm
{
    protected $user;

    function __construct(){ ?>
        <h3> Formularz rejestracji </h3>
        <form action="index.php" method="post">
          <p>Nazwa użytkownika <input type="text" name="user_name"</p>
          <p>Imie i nazwisko <input type="text" name="nam_surnam" </p>
          <p>Hasło <input type="password" required name="password"</p>
          <p>E-mail: <input type="email" name="email"</p>



           <p>
               <input type='submit' name='submit' value='Rejestruj'>
               <input type='reset' name='reset' value='Anuluj'>
           </p>

        </form>

<?php
    }

    function chceckUser(){
        $args = array(
            'user_name' => ['filter' => FILTER_VALIDATE_REGEXP,
                            'options' => ['regexp' => '/^[0-9A-Za-ząęłńśćźżó_-]{2,25}$/']
                ],
            "nam_surnam" =>['filter' => FILTER_VALIDATE_REGEXP,
                            'options' => ['regexp' => '/^[A-ZŁĄŹŻĆĄŚ][a-zążśźćł]{2,15}\s[A-ZŁĄŹŻĆĄŚ][a-zążśźćł]{2,15}-?([A-ZŁĄŹŻĆĄŚ][a-zążśźćł]{2,15}|)$/']
                ],
            'password' =>FILTER_SANITIZE_FULL_SPECIAL_CHARS,
            'email' => FILTER_SANITIZE_EMAIL
        );

        $dane = filter_input_array(INPUT_POST, $args);

        $errors ="";
        foreach($dane as $key => $val){
            if($val === false or $val === NULL){
                $errors.= $key." ";
            }
        }
        if($errors === ""){
            $this->user = new User($dane['user_name'], $dane['password'], $dane['nam_surnam'], $dane['email']);
        }
        else{
            echo "<p>Błędne dane:$errors</p>";
            $this->user = NULL;

        }

        return $this->user;
    }

}

