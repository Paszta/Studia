package com.company;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if(N % 2 == 1) System.out.println("Weird");
        else if(N % 2 == 0 && N >=2 && N <=5) System.out.println("Not weird");
        else if(N % 2 == 0 && N >=6 && N <=20) System.out.println("Weird");
        else if(N % 2 == 0 && N>20) System.out.println("Not weird");

        scanner.close();
    }
}
