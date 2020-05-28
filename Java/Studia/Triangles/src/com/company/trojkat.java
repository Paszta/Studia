package com.company;

import java.util.Arrays;

public class trojkat {
    private double[] tab;
    
    public trojkat(double a, double b, double c) {
        tab = new double[]{a, b, c};
    }

    public double getA() {
        return tab[0];
    }

    public double getB() {
        return tab[1];
    }

    public double getC() {
        return tab[2];
    }
    
    public double getobw() {
        return tab[0]+tab[1]+tab[2];
    }

    public double getP() {
        double p=this.getobw()/2;
        return Math.sqrt(p*(p-tab[0])*(p-tab[1])*(p-tab[2]));
    }

    public static void jaki(double a, double b, double c){
        double []tab={a,b,c};
        Arrays.sort(tab);
        if(tab[2] >= tab[0] + tab[1]) System.out.println("z tych boków nie da się zbudowac trójkąta");
        else {
            if(Math.pow(tab[2],2) == Math.pow(tab[1],2)+Math.pow(tab[0],2)) System.out.println("prosty");
            else if (Math.pow(tab[2],2) < Math.pow(tab[1],2)+Math.pow(tab[0],2)) System.out.println("ostrokątny");
            else if (Math.pow(tab[2],2) > Math.pow(tab[1],2)+Math.pow(tab[0],2)) System.out.println("rozwartokątny");
        }
    }
}
