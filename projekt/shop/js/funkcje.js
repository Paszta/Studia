function dodaj_1(){
    var radio1;

    document.getElementsByName("pierwszy").forEach(value => {
        if(value.checked){
            radio1 = value.value;
        }
    })

    var n1 = "Bunch of Sunflowers";

    sessionStorage.setItem(n1, radio1);


}

function dodaj_2(){
    var radio2;

    document.getElementsByName("drugi").forEach(value => {
        if(value.checked){
            radio2 = value.value;
        }
    })

    var n2 = "White Flowers...";

    sessionStorage.setItem(n2, radio2);


}


function dodaj_3(){
    var radio3;

    document.getElementsByName("trzeci").forEach(value => {
        if(value.checked){
            radio3 = value.value;
        }
    })

    var n3 = "Brown Brick House";

    sessionStorage.setItem(n3, radio3);


}


function dodaj_4(){
    var radio4;

    document.getElementsByName("czwarty").forEach(value => {
        if(value.checked){
            radio4 = value.value;
        }
    })

    var n4 = "Pink Flower";

    sessionStorage.setItem(n4, radio4);


}



function dodaj_5(){
    var radio5;

    document.getElementsByName("piaty").forEach(value => {
        if(value.checked){
            radio5 = value.value;
        }
    })

    var n5 = "Forest";

    sessionStorage.setItem(n5, radio5);


}



function dodaj_6(){
    var radio6;

    document.getElementsByName("szosty").forEach(value => {
        if(value.checked){
            radio6 = value.value;
        }
    })

    var n6 = "Yellow Bird";

    sessionStorage.setItem(n6, radio6);


}

function wyczysc(){
    sessionStorage.clear();
    document.getElementById("lista").innerHTML="";
}

function pokaz(){
 
        for(var i=0;i<sessionStorage.length;i++) { 
         $('#lista').append("<p id= "+i+ ">" + sessionStorage.key(i) + " : " + sessionStorage.getItem(sessionStorage.key(i))+ " zł"+ "</br>" + "</p>" )        
        }
              
    
}

function odswiez(){
    document.getElementById("lista").innerHTML="";
    pokaz();
}


 function suma(){
    var sum = 0; 
    if(sessionStorage.length >0){
        for(var i=0, len=sessionStorage.length; i<len; i++ ){
            var key = sessionStorage.key(i);
            var val = sessionStorage.getItem(key);
            sum+=parseInt(val);
                }
    }

    var s = document.getElementById("suma");
     s.value = sum;  

}