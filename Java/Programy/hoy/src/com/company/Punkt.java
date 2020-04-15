package com.company;

public class Punkt {

    private double[] Wspolrzedne;


    public Punkt(double x) {
    Wspolrzedne = new double[]{x,0};
    }

    public double getX() {
        return Wspolrzedne[0];
    }

    public void setY(double y) {
        Wspolrzedne[1] = y;
    }

    public double getY() {
        return Wspolrzedne[1];
    }
}
