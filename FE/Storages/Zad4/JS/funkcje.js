

$(document).ready(function () {

    $('#zapisz').click(function (){

        var item={};

        item.nazwa_produktu = $('#nazwa').val();
        item.cena = $('#cena').val();
        item.kolor = $('#kolor').val();
        item.ilosc = $('#liczba').val();
    
        var lista = JSON.parse(localStorage.getItem('lista'));
    
        if (lista===null) lista=[]; 
        lista.push(item); 
        
       localStorage.setItem('lista', JSON.stringify(lista));
    });

    $('#wyczysc').click(function(){
     
        localStorage.clear();
        $('#list').html("");

    });


    });
    function pokaz(){
        var lista = JSON.parse(localStorage.getItem('lista'));
        var element =$('#list');
        var tr = "Obecnie na liście zakupów <br/>";
        tr+="<table style='border: 2px solid black'; >";
        tr+="<tr> <td> Nazwa produktu </td> <td> Cena </td> <td> Kolor </td> <td> Ilość </td></tr>";


        for(let i = 0; i< lista.length; i++){
            tr+='<tr> <td>'+ lista[i].nazwa_produktu +'</td> <td>'+ lista[i].cena +'</td> <td>' + lista[i].kolor +'</td> <td>'+ lista[i].ilosc +'</td> <td> <button type="button" onclick="usun('+ i +')"> X </button> </td> <td> <button type="button" onclick="edit('+ i +')"> Edytuj </button> </td> </tr>';
        }

    element.html(tr);

    }

    function usun(i){
        var lista = JSON.parse(localStorage.getItem('lista'));
        if(confirm("Usunąć pozycje?")) lista.splice(i,1);
        localStorage.setItem('lista', JSON.stringify(lista));
        pokaz();
    }

    function edit(i){
        var lista = JSON.parse(localStorage.getItem('lista'));

        var n_nazwa = document.getElementById("nazwa").value;
        var n_cena = document.getElementById("cena").value;
        var n_kolor = document.getElementById("kolor").value;
        var n_ilosc = document.getElementById("liczba").value;

        lista[i].nazwa_produktu = n_nazwa;
        lista[i].cena = n_cena;
        lista[i].kolor = n_kolor;
        lista[i].ilosc = n_ilosc;

        localStorage.setItem('lista', JSON.stringify(lista));


        pokaz();
    }

 