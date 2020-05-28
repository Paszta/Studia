

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

    $('#wyswietl').click(function(){
        var lista = JSON.parse(localStorage.getItem('lista'));
        $('#list').append("Obecnie na liście zakupów <br/>");

    // for(let i = 0; i< lista.length; i++){
    //     $('#list').append(lista[i].nazwa_produktu + " " + lista[i].cena + " " +lista[i].kolor + " " + lista[i].ilosc + "<br/>")
    $('#list').append('<table style="border: 2px solid black;">');
    $('#list').append("<tr> <td> Nazwa produktu </td> <td> Cena </td> <td> Kolor </td> <td> Ilość </td></tr>");


        for(let i = 0; i< lista.length; i++){
            $('#list').append("<tr>" + "<td>"+ lista[i].nazwa_produktu +"</td>" + "<td>"+ lista[i].cena +"</td>" + "<td>"+ lista[i].kolor +"</td>" + "<td>"+ lista[i].ilosc +"</td>" + "</tr>");
    }
    $('#list').append("</table>");

    });

    $('#wyczysc').click(function(){
     
        localStorage.clear();
        $('#list').html("");

    });


    });
