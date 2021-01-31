<?php


class UserManager
{

    public function loginForm(){
        ?>
        <h1>Formularz logowania: </h1>
        <form action="processlogin.php" method="POST">
            <table>
                <tbody>
                <tr>
                    <td>Nazwa użytkownika : </td>
                    <td> <input type="text" name="userName"/> </td>
                </tr>
                <tr>
                    <td>Hasło :</td>
                    <td><input type="password" name="passwd" /></td>
                </tr>
                </tbody>
            </table>

            <input type="submit" name="submit" value="Zaloguj" />
        </form>
        <?php
    }

    public function login($db){
        $args=[
            'userName'=> FILTER_SANITIZE_MAGIC_QUOTES,
            'passwd'=> FILTER_SANITIZE_MAGIC_QUOTES
        ];

        $dane=filter_input_array(INPUT_POST,$args);

        $userId = $db->selectUser($dane['userName'],$dane['passwd'],"users");

        if($userId >= 0 ){
            session_start();
            $sql_del = "DELETE FROM logged_in_users WHERE userId = '$userId'";
            $db->delete($sql_del);
            $data=(new DateTime())->format('Y-m-d H:i:sP');

            $id=session_id();

            echo "Id sesji = ".session_id()."<br/>";

            $sql_ins = "INSERT INTO logged_in_users (sessionId,userId,lastUpdate) VALUES ('".session_id()."','".$userId."','".$data."')";
            $db->insert($sql_ins);

            $_SESSION[".$id."] = serialize($dane);
          //  echo serialize($dane);



        }
        echo "Id usera: '$userId' <br/>";
        return $userId;

    }

    public function logout($db){
        session_start();

        $sess = session_id();

        if ( isset($_COOKIE[session_name()]) ) {
            setcookie(session_name(),'', time() - 42000, '/');
        }
        session_destroy();

        $sql = "DELETE FROM logged_in_users WHERE sessionId='$sess'";
        $db->delete($sql);
        echo "Wylogowano <br/> ";

    }

    public function getLoggedInUser($db, $sessionId){
        $sql = "SELECT userId FROM logged_in_users WHERE sessionId='$sessionId'";
        $userId = $db -> selectLoggedInUser($sql);

        if($userId > 0){
            return $userId;
        }
        else return $userId = -1;


    }


}