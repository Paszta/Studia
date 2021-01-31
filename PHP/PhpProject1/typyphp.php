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
        <?php
        $i=134;
        $f=67.67;
        $z=0;
        $logiczna=true;
        $strnum="0";
        $strchar="typy w php";
        $numtab=[1,2,3,4];
        $emptab=[];
        $strtab=["a", "b", "c", "d"];
        $data = new DateTime;
        
        $logiczna2 = false;
        
        echo"<br>";
        
        print("i=$i, f=$f, z=$z,\n logiczna=$logiczna, strnum=$strnum,strchar=$strchar");
        
        echo"<br>";
        print("Tablica numeryczna: ");
        for($i=0; $i<count($numtab); $i++){
            print("$numtab[$i]");
        }
        
        echo"<br>";
        print("Tablica znaków: ");
        for($i=0; $i<count($strtab); $i++){
            print("$strtab[$i]");
        }
        
         echo"<br>";
         
         if(is_bool($logiczna)===true){
             echo"Zmienna logiczna jest typu boolean";
         }
         
          echo"<br>";
         
         if(is_int($i)===true){
             echo"Zmienna i jest typu int";
         }
         
          echo"<br>";
         
         if(is_numeric($strnum)===true){
             echo"Zmienna z jest typu numerycznego";
         }
         
         echo"<br>";
         
          if(is_string($strchar)===true){
             echo"Zmienna strchar jest typu string";
         }
         
         echo"<br>";
         
          if(is_array($numtab)===true){
             echo"Numtab jest tablicą";
         }
         
         echo"<br>";
         
          if(is_array($strtab)===true){
             echo"Strtab jest tablicą";
         }
         
         echo"<br>";
         
          if(is_object($data)===true){
             echo"Zmienna data jest obiektem";
         }
         
         echo"<br>";
         
         var_dump($numtab);
         
         echo"<br>";
         
         print_r($strtab);
         
         echo"<br>";
         
         if($logiczna2==$z){
             echo"Zmienna logiczna false równa się zmiennej z=0";
         }
         else {
             echo"Zmienna logiczna false nie równa się równa się zmiennej z=0";
         }
         
         echo"<br>";
         
           if($logiczna2===$z){
             echo"Zmienna logiczna false równa się zmiennej z=0";
         }
         else {
             echo"Zmienna logiczna false nie równa się równa się zmiennej z=0";
         }
         
         
         
        ?>
    </body>
</html>
