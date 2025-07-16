package Lib;

import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    private ArrayList<String> arr;
    Scanner input;

    public Data(){
        arr = new ArrayList<>();
        input = new Scanner(System.in);
    }
    public void printarray(){
        System.out.print("Data = ");
        for (String st : arr) {
            System.out.print(st + " ");
        }
        System.out.println("\n");
    }    
    public void printmenu(){
        System.out.println("=====MENU=====");
        System.out.println("1) Add Text to back");
        System.out.println("2) Add Text at index");
        System.out.println("3) Edit Text");
        System.out.println("4) Remove Text by index");
        System.out.println("5) Remove Text by value");
        System.out.println("6) Exit");
    }
    public void add2back(){
        System.out.println("== Add Text to back ==");
        System.out.print("Input Text: ");
        String st = input.nextLine();
        arr.add(st);
        printarray();
    }
    public void addind(){
        System.out.println("== Add Text to back ==");
        System.out.print("Input Index: ");
        int ind = input.nextInt();
        input.nextLine();
        System.out.print("Input Text: ");
        String st = input.nextLine();
        arr.add(ind,st);
        printarray();
    }
    public void Edittext(){
        System.out.println("== Edit Text ==");
        System.out.print("Input Index: ");
        int ind = input.nextInt();
        input.nextLine();
        System.out.print("Input Text: ");
        String st = input.nextLine();
        arr.set(ind,st);
        printarray();
    }
    public void RemoveInd(){
        System.out.println("== Remove Text by index ==");
        System.out.print("Input Index: ");
        int ind = input.nextInt();
        arr.remove(ind);
        printarray();
    }
    public void RemoveValue(){
        System.out.println("== Remove Text by value ==");
        System.out.print("Input Text: ");
        String st = input.nextLine();
        arr.remove(st);
        printarray();
    }
}
