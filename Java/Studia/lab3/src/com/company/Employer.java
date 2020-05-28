package com.company;

public class Employer extends Person {
    private String CompanyName, Prefernces;
    private int salary;

    public Employer(String name, String surname, int age, char gender, String companyName, String prefernces, int salary) {
        super(name, surname, age, gender);
        CompanyName = companyName;
        Prefernces = prefernces;
        this.salary = salary;
    }

    public void Hire(Employee e){
        if(Prefernces == e.job && e.workplace == "no workplace"){
            e.workplace = this.CompanyName;
            e.income = this.salary;
            super.Hire();
        }
    }
    public String IncomeSrc(){
        return "none";
    };
}
