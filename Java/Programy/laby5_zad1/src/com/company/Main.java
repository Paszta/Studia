package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

        public void printList(String[] list, String title){
            System.out.println(title);
            for(String str : list){
                System.out.println(str);
            }
        }

        public void PrintShortNames(String[] list){
            for(String str : list){
                if(str.lastIndexOf('.') >= 0) {
                System.out.println(str.substring(0, str.lastIndexOf('.')));
                }
                else System.out.println(str);
            }
        }



        public static void main(String[] args) {
        Main App_Obj = new Main();
        File f = new File(".");
        String[] ContainsList = f.list();

            System.out.println("Podpunkt A");
	    App_Obj.printList(ContainsList, "Lista Zasobów");
        Arrays.sort(ContainsList);
        App_Obj.printList(ContainsList, "Lista Zasobów Posortowana");

            System.out.println("Podpunkt B");
        App_Obj.PrintShortNames(ContainsList);
    }
}
