package com.company;

// Declare your class here. Do not use the 'public' access modifier.
// Declare the price instance variable

import java.util.Scanner;

abstract class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    abstract void display();
}

class MyBook extends Book {
    private int price;

    public MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }
@Override
 public void display(){
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("Price: " + price);

 }

// End class
}
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}
