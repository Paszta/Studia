$(document).ready(function () {

    $('#save').click(function (){

        var rgb = $('#rgb').val();
        var kolor = $('#kolor').val();
        
      localStorage.setItem(rgb, kolor);
         
    });

    $('#show').click(function (){
 
 for(var i=0;i<localStorage.length;i++) { 
  $('#lista').append("<p id= "+i+ ">" + localStorage.key(i) + " : " + localStorage.getItem(localStorage.key(i)) + "</br>" + "</p>" );
  $('#'+i).css("background", localStorage.getItem(localStorage.key(i)));
 
 }
       
  });

  $('#clear').click(function (){
 
  localStorage.clear();
  $('#lista').html("");
          
     });
    });
    