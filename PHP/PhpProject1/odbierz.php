<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h2> Dane osobowe </h2>
        <?php
        if(isset($_REQUEST['nazwisko'])&&($_REQUEST['nazwisko']!="")){
            $nazwisko = htmlspecialchars(trim($_REQUEST['nazwisko']));
            echo 'Nazwisko:'.$nazwisko.'</br>'; 
        }
        else echo 'Nie wpisano nazwiska <br/>';
        
        if(isset($_REQUEST['wiek'])&&($_REQUEST['wiek']!="")){
            $wiek = htmlspecialchars(trim($_REQUEST['wiek']));
            echo 'Wiek:'.$wiek.'</br>'; 
        }
        else echo 'Nie wpisano wieku <br/>';
        
        if(isset($_REQUEST['panstwo'])&&($_REQUEST['panstwo']!="")){
            $panstwo = htmlspecialchars(($_REQUEST['panstwo']));
            echo 'Nazwisko:'.$panstwo.'</br>'; 
        }
        else echo 'Nie wpisano państwa <br/>';
        
         if(isset($_REQUEST['email'])&&($_REQUEST['email']!="")){
            $email = htmlspecialchars(trim($_REQUEST['email']));
            echo 'E-mail:'.$email.'</br>'; 
        }
        else echo 'Nie wpisano e-mail <br/>';
        ?>
       
        
        <h2> Zamówione produkty </h2>
        <?php
     if (isset($_REQUEST['submit'])) {
         $produkty = $_REQUEST['jezyki'];
         
         foreach($produkty as $key){
             echo'Produkty:' .$key. '<br/>';
         }
     }
     echo"<br>";
     echo"<br>";
     
          if(isset($_REQUEST['sposob_zaplaty'])&&($_REQUEST['sposob_zaplaty']!="")){
            $sposob_zaplaty = htmlspecialchars(($_REQUEST['sposob_zaplaty']));
            echo 'Sposób zapłaty:'.$sposob_zaplaty.'</br>'; 
        }
        else echo 'Nie wybrano sposobu zapłaty <br/>';
     

        ?>
    </body>
</html>
