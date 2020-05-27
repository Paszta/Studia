package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Punkt p = new Punkt(1);
        Scanner scan = new Scanner(System.in);
        FunKwadrat fk = new FunKwadrat(scan.nextDouble(),scan.nextDouble(),scan.nextDouble());
        fk.oblicz(p);
        System.out.println(Arrays.toString(fk.pierw(p)));
    }
}
