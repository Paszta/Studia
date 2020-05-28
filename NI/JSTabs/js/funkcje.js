function pokaz(id)
{
 var tresc="";
 switch (id)
 { 
case 2: tresc += pokazGalerie();break;
 case 3: tresc += pokazPost(); break;
 case 4: tresc += pokazKontakt();break;
 default: tresc += pokazOmnie();
 }
 document.getElementById('blok').innerHTML = tresc;
}
function pokazOmnie(){
 var tresc ='<h2><br />O mnie</h2> ';
 tresc += '<p>Lorem ipsum dolor pariatur,...</p>'+
 '<p class="srodek"><img src="images/baner.jpg" alt="Zdjęcie" /></p>'+
 '<article><h2>Moje hobby</h2><p>'+
 'Lorem ipsum dolor sit amet,...'+
 'mollit anim id est laborum.</p></article>';
 return tresc;
}
function pokazGalerie()
{
 var tresc='<h2><br />Moja galeria</h2>';
 tresc+=' <div class="galeria">';

 for(let i=1;i<=10;i++)
 {
 tresc+='<div class="slajd">  <img src="zdjecia/obraz' + i + '.JPG" /> </div>';
 }
 return tresc+'</div>';
}
function pokazKontakt()
{
 var tresc='<h2><br />Kontakt</h2>';
 //uzupełnij treść:
 // tresc+= ...
 return tresc;
}
function pokazPost()
{
 //funkcja generuje kod formularza – dane wpisane w odpowiednie pola przez
 //użytkownika zostaną przekazane mailem na wskazany adres, ale najpierw po
 //zajściu zdarzenia submit (wyślij) – zostanie wywołana funkcja pokazDane()
 var tresc='<h2><br />Dodaj post</h2>';
 tresc+='<article class="srodek" ><form action="mailto:b.panczyk@pollub.pl" method="post" onsubmit="return pokazDane();">' +

 'Twój email:<br /> <input type="email" name="email" id="email"required  placeholder="xxxxxx@xxxx.xx" /><br />'+

 'Imię i nazwisko: </br> <input name="person" id="person" requied pattern="^[a-zA-Z]{2,} [a-zA-z]{1,}$" /> </br>' +

 'Telefon: </br> <input type="number" name="phone" id="phone" requied pattern="^([0-9]{9}" /> </br> '+

 ' Zainteresowania : </br> <input type="checkbox" name="zainteresowania" id="sport" value="Sport"/> Sport ' + 
 '<input type="checkbox" name="zainteresowania" id="muzyka" value="Muzyka"/> Muzyka ' + 
 '<input type="checkbox" name="zainteresowania" id="film" value="Film"/> Film ' + 
 '<input type="checkbox" name="zainteresowania" id="inne" value="Inne"/> Inne  </br>' + 

 'Wiek: </br> <input type="radio" name="wiek" id="dzieciaczki" value ="Do 10 lat" /> Do 10 lat' + 
 '<input type="radio" name="wiek" id="nastolatkowie" value =" 11-20 lat" /> 11-20 lat' + 
 '<input type="radio" name="wiek" id="m_dorosli" value=" 21-40 lat " /> 21-40 lat ' + 
 '<input type="radio" name="wiek" id="dorosli" value="41-70 lat" /> 41-70 lat ' + 
 '<input type="radio" name="wiek" id="emeryci" value="+71 lat" /> +71 lat </br> ' + 
 // dodaj kolejne 2 pola formularza
 'Komentarz: <br /><textarea rows="3" cols="20" id="wiadomosc"name="wiadomosc" required></textarea>'+
 '<br /> <input type="submit" name="wyslij" value="Wyślij" />'+
 '</form></article>';
 return tresc;
}
function pokazDane()
{
 //Funkcja zbiera dane wpisane w pola formularza i wyświetla okienko
 //typu confirm do zatwierdzenia przez użytkownika:
 var dane="Następujące dane zostaną wysłane:\n";
 dane+="Email: "+document.getElementById('email').value+"\n";
 dane+="Imie i nazwisko: "+document.getElementById('person').value+"\n";
 dane+="Telefon: "+document.getElementById('phone').value+"\n";
 dane+="Zainteresowania: ";
document.getElementsByName('zainteresowania').forEach(element => {
     if(element.checked) dane+= element.value +", ";
 });
 dane+="\n";
 dane+="Wiek: "+document.querySelector("input[name=wiek]:checked").value+"\n";
 dane+="Komentarz: "+document.getElementById('wiadomosc').value+"\n";

 // uzupełnij dane ...
 if (window.confirm(dane)) return true;
 else return false;
}