package app;

import java.io.*;
import java.util.*;

public class App {

    public static void main(final String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        final Scanner scr = new Scanner(System.in);
        boolean isDivided = false;
        int sqrt_n;
        final int T = scr.nextInt();
        for(int i = 0; i < T ; i++){
            final int n = scr.nextInt();
             sqrt_n = (int) Math.sqrt(n);
             if( n%2 == 0 && n!=2) isDivided = true;
             else{
            for(int j = 2; j <= sqrt_n ; j++){
                    if(n%j != 0) {
                                isDivided = false;
                            }
                    else {
                        isDivided = true;
                            break;
                        }       
                    }
                }
            if(isDivided == true || n == 1 || n == 0) System.out.println("Not prime");
                else System.out.println("Prime");
        }
    }
}