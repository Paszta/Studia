function oblicz_rate() {
var K = parseInt(document.getElementById("k").value);
var PR = parseFloat(document.getElementById("pr").value);
var N = parseInt(document.getElementById("n").value);

 var OPR = document.getElementById("wynik");
 OPR.value= parseFloat((K*(PR/100)/12)/(1-(1/(Math.pow(1+(PR/100)/12, N)))));

if(isFinite(OPR.value) === false)  {alert("Wartość nieprawidłowa!!!!");}

var KODS = document.getElementById("kods");
KODS.value = (OPR.value*N);

}