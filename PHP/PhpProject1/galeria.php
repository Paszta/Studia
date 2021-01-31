<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

        <?php
                
        function galeria($rows, $cols){
            $nr=0;
            for($i=0;$i<$rows;$i++ ){
                for($j=0;$j<$cols;$j++){
                    $nr++;
                    print("<img src='miniatury/obraz$nr.JPG' alt ='obraz$nr' />");
                }
              echo"<br>";  
            }
        }
        
        galeria(3,3);
        
