package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Employee e = new Employee("Agata", "Wrzesniewska", 20, 'w', "Concept Artist", "no workplace", 0);
        Employee c = new Employee("Czarek", "Płatek", 20, 'm', "Senior Java Developer", "no workplace", 0);
        Employee a = new Employee("Alunia", "Pasztelan", 19, 'w', "Senior HLA Developer", "no workplace", 0);
        //Employee.report(e);
        Employer em = new Employer("Janusz","Superbebzon", 60, 'm',"JanuszeX SA", "Senior Java Developer", 1500000);
        //em.Hire(e);
        //Employee.report(e);

        ArrayList <Employee> WorkerList = new ArrayList<Employee>();
        WorkerList.add(e);
        WorkerList.add(c);
        WorkerList.add(a);

        for(Employee employee : WorkerList ){
            em.Hire(employee);
        }
        Employee.report(e);
        Employee.report(c);
        Employee.report(a);
    }
}
