package app;

import java.io.*;
import java.util.*;

public class App {

    public static int feeValue(int[] A, int[] E){
     int fine = 0;
     if( A[2] == E[2] && A[1] == E[1] && A[0] < E[0]) fine = 0;
     else{
         if(A[2] > E[2]) fine = 10000;
         else if (A[2] == E[2] && A[1] > E[1]) fine = 500*(A[1]-E[1]);
         else if (A[2] == E[2] && A[1] == E[1] && A[0] > E[0]) fine = 15*(A[0]-E[0]);
     }
    

        return fine;
    }



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        //Actual
        int D_a = sc.nextInt();
        int M_a = sc.nextInt();
        int Y_a = sc.nextInt();
        int[] actual = {D_a, M_a, Y_a};

        //Expected
        int D_e = sc.nextInt();
        int M_e = sc.nextInt();
        int Y_e = sc.nextInt();
        int[] expected = {D_e, M_e, Y_e};
     

        System.out.println(feeValue(actual, expected));

        
    }
}