$(document).ready(function () {

    $('#save').click(function (){

        var rgb = $('#rgb').val();
        var kolor = $('#kolor').val();
        
      sessionStorage.setItem(rgb, kolor);
         
    });

    $('#show').click(function (){
 
 for(var i=0;i<sessionStorage.length;i++) { 
  $('#lista').append("<p id= "+i+ ">" + sessionStorage.key(i) + " : " + sessionStorage.getItem(sessionStorage.key(i)) + "</br>" + "</p>" );
  $('#'+i).css("background", sessionStorage.getItem(sessionStorage.key(i)));
 
 }
       
  });

  $('#clear').click(function (){
 
  sessionStorage.clear();
  $('#lista').html("");
          
     });
    });
    