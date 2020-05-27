package com.company;

public class Employee extends Person {
    public String job;
    public String workplace;
    public double income;

    public Employee(String name, String surname, int age, char gender, String job, String workplace, double income) {
        super(name, surname, age, gender);
        this.job = job;
        this.workplace = workplace;
        this.income = income;
    }

    void Hire(String workplace, double income){
        if(workplace == "no workplace" || workplace == ""){
            super.Hire();
            System.out.println("Employee has been hired");
            this.workplace = workplace;
            this.income = income;
        }
    }

    @Override
    public String IncomeSrc() {
        if(this.income == 0) return "No income";
        else if(this.income >0) return this.workplace +", "+ this.income;
        else if(this.income <0) return "Error";
        return null;
    }

    public static void report(Employee e){
        System.out.println("Name and Surname: " + e.WhatsUrName() + ", gender: " + e.AreUWoman() + ", age: " + e.YourAge() + ", job: " + e.job + ", workplace and income: " + e.IncomeSrc() + " per month");
    }



}
