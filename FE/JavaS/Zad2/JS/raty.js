$(document).ready(function () {
   $("#tresc").css("background", "#A376CF");
   $("#tresc").css("font-weight", "bold");
   $("input").css("font-weight", "bold");
   $("#wynik").addClass("zielony");
   $("#kods").addClass("zielony");
   $(".zielony").css("background", "#CCFFCC");

    $("button").click(function oblicz_rate(){
        var K = parseInt($('#k').val());
        var PR = parseInt($('#pr').val());
        var N = parseInt($('#n').val());
        

        var OPR = parseFloat((K*(PR/100)/12)/(1-(1/(Math.pow(1+(PR/100)/12, N)))));

        if(isFinite(OPR) === false) $('#wynik').val("Błąd");
        else $('#wynik').val(OPR);

        

        var KODS = OPR*N;

        if(isFinite(KODS) === false) $('#kods').val("Błąd");
        else $('#kods').val(KODS);
         
    });

});
    
