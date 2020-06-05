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

        if(validation()){

        localStorage.setItem('lista', JSON.stringify(lista));
        }

    });


  $('#show').click(function(){
      pokaz();
  });


    $('#clear').click(function(){
       localStorage.clear();
       $('#list').html("");

    });





});

function rem(i){
    var lista = JSON.parse(localStorage.getItem('lista'));
    if(confirm("Usuąć dane?")) lista.splice(i,1);
    localStorage.setItem('lista', JSON.stringify(lista));
    pokaz();

}
function pokaz(){
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
            tekst+= "<tr> <td>  <button class='remove btn btn-outline-danger' onclick='rem("+i+")'> X </button> </td> </tr>";
            // tekst+= "<tr> <td>  <button onclick='openForm()'> Edytuj </button> </td> </tr>";
            tekst+='<tr> <td> <button type="button" class="btn btn-outline-success" data-toggle="modal" onclick="edit('+i+')" data-target="#exampleModal">Edytuj</button> </td> </tr>';

            tekst+="<br/> </table>";
        }
    }


    element.html(tekst);

    }

   function zamien(i){
        var lista = JSON.parse(localStorage.getItem('lista'));

        var n_imie = $('#z_imie').val();
        var n_nazwisko = $('#z_nazwisko').val();
        var n_wiek = $('#z_wiek').val();
        var n_plec;

        if($('#z_kobieta').is(":checked")){
            n_plec = $('#z_kobieta').val();
        }
        else if($('#z_mezczyzna').is(":checked")){
            n_plec = $('#z_mezczyzna').val();
        }

        var n_email = $('#z_email').val();
        var n_nr = $('#z_numer').val();
        var n_ulica = $('#z_ulica').val();
        var n_miasto = $('#z_miasto').val();


        lista[i].name = n_imie;
        lista[i].surname = n_nazwisko;
        lista[i].age = n_wiek;
        lista[i].gender = n_plec;
        lista[i].email = n_email;
        lista[i].nr = n_nr;
        lista[i].street = n_ulica;
        lista[i].city = n_miasto;


        if(validation_z()){

            localStorage.setItem('lista', JSON.stringify(lista));
            }
    
        pokaz();
    }

    function edit(i){
        var d = $('#przycisk');
        var t='<button type="button" id="zamien" class="btn btn-outline-success" onclick="zamien('+i+')">Zapisz zmiany</button>';
       d.html(t);

    }


    function validation(){
        return(document.getElementById('imie').checkValidity() 
        && document.getElementById('nazwisko').checkValidity() 
        && document.getElementById('email').checkValidity() 
        && document.getElementById('numer').checkValidity());
    }

    
    function validation_z(){
        return(document.getElementById('z_imie').checkValidity() 
        && document.getElementById('z_nazwisko').checkValidity() 
        && document.getElementById('z_email').checkValidity() 
        && document.getElementById('z_numer').checkValidity());
    }
  