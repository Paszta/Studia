package com.company;

public class Main {

    public static void main(String[] args) {
	    trojkat.jaki(3,4,5);
        trojkat.jaki(4,4,4);
        trojkat.jaki(1,1,10);
	    trojkat t0 = new trojkat(3,4,5);
        trojkat t1 = new trojkat(4,4,4);
        trojkat t2 = new trojkat(1,1,10);
        System.out.println("obwody to : \n" + t0.getobw()+ ", " + t1.getobw() + ", " + t2.getobw());
        System.out.println("pola to : \n" + t0.getP()+ ", " + t1.getP() + ", " + t2.getP());


    }
}
