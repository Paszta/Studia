package com.company;

public class FunKwadrat extends Funckaj {
    private double a,b,c;

    public FunKwadrat(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double delta(Punkt p){
        double d = Math.pow(b,2) - (4*a*(c-p.getY()));
        return d;
    }

    public double[] pierw(Punkt p){
        /*Pair<Double, Double> pierwiastki;
        pierwiastki = new Pair<>();*/
        double[] pierwiastki = new double[2];

        if(this.delta(p)<0){
                System.out.println("Funkcja nie ma pierwiastków.");
            }
        else if(this.delta(p) == 0){
                System.out.println("Funkcja ma pierwiastek podwójny");
                pierwiastki[0] = (-b)/2*a;
                pierwiastki[1] = (-b)/2*a;
                return pierwiastki;
        }
        else if(this.delta(p)>0){
                pierwiastki[0]=(-b - Math.sqrt(this.delta(p)))/2*a;
                pierwiastki[1]=(-b + Math.sqrt(this.delta(p)))/2*a;
                return pierwiastki;
            }

        return null;
    }

        @Override
        public void oblicz(Punkt p) {
            double tomp = a*Math.pow(p.getX(),2)+b*p.getX()+c;
            p.setY(tomp);
        }


}

