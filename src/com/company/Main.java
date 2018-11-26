package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static mobilephone mobilephone = new mobilephone("01202415547");

    public static void main(String[] args) {

        boolean quit = false;
        printlist();
        while (!quit) {
            int marker = scanner.nextInt();
            scanner.nextLine();
            switch (marker) {
                case 0:
                    System.out.println("\n bye");
                    quit = true;
                    break;
                case 1:
                    mobilephone.printcontacts();
                    break;
                case 2:
                    addcontact();
                    break;

                case 3:
                    updatecontact();
                    break;
                case 4:
                    removecontact();
                    break;
                case 5:

                    printlist();
                    break;
            }
        }
    }

    private static void printlist() {
        System.out.println("0 to shutdown \n +" +
                "1 to print contacts \n " +
                "2 to add new contact \n " +
                "3 to update exsiting contact \n" +
                "4 to remove exsiting contact \n" +
                "5 to print a list");
        System.out.println("select your action");
    }

    private static void addcontact() {
        System.out.println("enter new contact name ");
        String name = scanner.nextLine();
        System.out.println("enter new contact number");
        String number = scanner.nextLine();
        contacts newcontact = contacts.createcontact(name, number);
        if (mobilephone.addnewcontact(newcontact)) {
            System.out.println("contact " + name + "has beed added ");
        }
    }

    private static void updatecontact() {
        System.out.println("enter exciting contact name : ");
        String name = scanner.nextLine();


        contacts exsistingname = mobilephone.querycontact(name);
        if (exsistingname == null) {
            System.out.println("contact not found");
            return;
        }
        System.out.println("enter your new contact name ");
        String newname = scanner.nextLine();
        System.out.println("enter your new number");
        String number = scanner.nextLine();
        contacts newcontact = contacts.createcontact(newname, number);
        mobilephone.updatecontact(exsistingname, newcontact);
        System.out.println("Succesfuly updated ");
        //mobilephone.updatecontact(name,newname);
    }

    private static void removecontact() {
        System.out.println("enter exciting contact name : ");
        String name = scanner.nextLine();


        contacts exsistingname = mobilephone.querycontact(name);
        if (exsistingname == null) {
            System.out.println("contact not found");
            return;
        }
        if (mobilephone.removecontact(exsistingname)) {
            System.out.println("was deleted");
        }
        else {
            System.out.println("error");
        }
    }
}
