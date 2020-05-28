package app;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class App {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        String comp = "@gmail.com";
        ArrayList<String> names = new ArrayList<>();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            if(firstNameEmailID[1].contains(comp)) names.add(firstNameEmailID[0]);
        }

       Collections.sort(names);

      // System.out.println(names);
       for(String nam : names) System.out.println(nam);

        scanner.close();
    }
}
