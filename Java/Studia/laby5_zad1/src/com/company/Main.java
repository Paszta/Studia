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

        public static ArrayList findExt(String[] list, String ext) {
            ArrayList limitedList = new ArrayList();
            for (String position : list) {
                if (position.endsWith(ext))
                    limitedList.add(position);
            }

            return limitedList;

        }


        public static ArrayList findCont(String[] list, String subs) {
            ArrayList newList = new ArrayList<>();
            for (String position : list) {
                if (position.lastIndexOf(".") >= 0)
                    if((position.substring(0, position.lastIndexOf("."))).contains(subs)){
                    newList.add(position);
            }
        }

            return newList;
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

            ArrayList limitedArr = findExt(ContainsList, "txt");
            String[] newArray = new String[limitedArr.size()];
            limitedArr.toArray(newArray);
            App_Obj.printList(newArray, "Podpunkt C");

            ArrayList splitted = findCont(ContainsList, "i");
            App_Obj.printList(splitted.toString().split(","), "Podupnkt D");

            System.out.println("Podpunkt E");
            String[] str_array = new String[splitted.size()];
            splitted.toArray(str_array);
            App_Obj.PrintShortNames(str_array);

            System.out.println("Podpunkt F");
            int position;
            position = Arrays.binarySearch(ContainsList, "src") + 1;
            System.out.println("Pozycja folderu src to: " + position);


            
    }
}
