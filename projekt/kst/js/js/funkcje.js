$(document).ready(function(){

    $('#save').click(function(){
        var person = {};
        person.name= $('#imie').val();
        person.surname= $('#nazwisko').val();
        person.age= $('#wiek').val();

        if($('#kobieta').is(":checked")){
            person.gender = $('#kobieta').val();
        }
        else if($('#mezczyzna').is(":checked")){
            person.gender = $('#mezczyzna').val();
        }

        person.email= $('#email').val();
        person.nr= $('#numer').val();
        person.street= $('#ulica').val();
        person.city= $('#miasto').val();


        var lista = JSON.parse(localStorage.getItem('lista'));
        if (lista===null) lista=[]; 
        lista.push(person); 

        localStorage.setItem('lista', JSON.stringify(lista));

    });


  $('#show').click(function(){
    var lista = JSON.parse(localStorage.getItem('lista'));
    var element = $('#list');
    var tekst="";
    tekst+="<h2> Dane przechowywane </h2>";
    if(lista === null){
        tekst+="<p>Brak danych</p>"
         element.html(tekst);
        }
    else{
        
        for(let i=0; i< lista.length; i++){
            tekst+="<table class='tlo'>";
            tekst+= "<tr>" + "<td> Imię: </td>" + "<td>" + lista[i].name +"</td>" + "</tr>";
            tekst+= "<tr>" + "<td> Naziwsko: </td>" + "<td>" + lista[i].surname +"</td>" + "</tr>";
            tekst+= "<tr>" + "<td> Wiek: </td>" + "<td>" + lista[i].age +"</td>" + "</tr>";
            tekst+= "<tr>" + "<td> Płeć: </td>" + "<td>" + lista[i].gender +"</td>" + "</tr>";
            tekst+= "<tr>" + "<td> E-mail: </td>" + "<td>" + lista[i].email +"</td>" + "</tr>";
            tekst+= "<tr>" + "<td> Numer telefonu: </td>" + "<td>" + lista[i].nr +"</td>" + "</tr>";
            tekst+= "<tr>" + "<td> Ulica i numer: </td>" + "<td>" + lista[i].street +"</td>" + "</tr>";
            tekst+= "<tr>" + "<td> Miasto: </td>" + "<td>" + lista[i].city +"</td>" + "</tr>";
            tekst+="</table>";
        }
    }



    element.html(tekst);

    });


    $('#clear').click(function(){
       localStorage.clear();
       $('#list').html("");

    });


});