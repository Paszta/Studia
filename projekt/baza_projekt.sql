create table klienci_p(
    idKlienta int(11) primary key auto_increment,
    login varchar(45) not null unique,
    fullname varchar(100) not null,
    haslo varchar(50) not null,
    wiek int(2) not null,
    plec enum('Kobieta','Mezczyzna','Nieokreslone') not null default 'Nieokreslone',
    email varchar(50) not null,
    telefon int(9) not null,
    ulica varchar(50),
    miasto varchar(70) not null,
    status int(1) not null
    );

drop table klienci_p;


