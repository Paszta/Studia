class User{
    constructor(email="", login="user",pass="user") {
    this.login=login;
   this.pass=pass;
   this.email=email;
    }
    static pokaz(){
    return "Dane użytkownika: login:"+ this.login + ", hasło: " + this.pass + ", email: " +this.email;
    }
   
    static formularzRejestracji(){
    var formularz = "";

    formularz += '<form>';
    formularz += 'Email: <input type="email" id="email"/> <br/> ';
    formularz += 'Login: <input type="text" id="login"/> <br/> ';
    formularz += 'Hasło: <input type="password" id="pass"/> <br/> ';
    formularz += '</form>';

    return formularz;
    } 
    } 

    document.addEventListener('DOMContentLoaded', () => {
        var user=new User();
       
    });