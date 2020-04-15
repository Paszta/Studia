package com.company;

public abstract class Person {
    private String name;
    private String surname;
    private int age;
    private char gender;
    private String occupation;
    private boolean ifEmployed = false;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = 0;
        this.gender = 'n';
        this.occupation = "no_data";
    }

    public Person(String name, String surname, int age, char gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.occupation = "no_data";
    }

    public Person(){
        this("no_data", "no_data", 0, 'n');
    }

    public String WhatsUrName(){
        return this.name +" "+this.surname;
    }

    public String AreUWoman(){
        switch(this.gender) {
            case 'w':
                return "women";
            case 'm':
                return "men";
            case 'n':
                return "no data";
            default:
                return "Error";
        }
        }
    public int YourAge(){
        return this.age;
    }

    protected void Hire() {
        this.ifEmployed = true;
    }

    public boolean isIfEmployed() {
        return ifEmployed;
    }

    public abstract String IncomeSrc();
}
