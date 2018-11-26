package com.company;

import java.util.ArrayList;

public class mobilephone {
    private int ahmed = 0 ;
    private String mohamed ;
    private String phonenumber;
    private ArrayList<contacts> mycontacts;

    public mobilephone(String phonenumber) {
        this.phonenumber = phonenumber;
        this.mycontacts = new ArrayList<contacts>();
    }

    public boolean addnewcontact(contacts contact) {
        if (findcontact(contact.getName()) >= 0) {

            System.out.println("contact is already on file");
            return false;
        }
        mycontacts.add(contact);
        return true;
    }

    public void updatecontact(contacts oldcontact, contacts newcontact) {
        int position = findcontact(oldcontact);
        if (position < 0) {
            System.out.println("contact not found");
        } else {
            this.mycontacts.set(position, newcontact);
            System.out.println(oldcontact + "was replaced by " + newcontact);
        }
    }

    private int findcontact(contacts member) {

        return this.mycontacts.indexOf(member);
    }

    private int findcontact(String name) {
        for (int i = 0; i < this.mycontacts.size(); i++) {
            contacts contact = this.mycontacts.get(i);

            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;


    }

    public String querycontact(contacts contact) {
        if (findcontact(contact) > 0) {
            return contact.getName();
        }
        return null;
    }

    public contacts querycontact(String name) {
        int position = findcontact(name);
        if (position >= 0) {
            return this.mycontacts.get(position);
        }
        return null;
    }

    public boolean removecontact(contacts contact) {
        int position = findcontact(contact);
        if (position < 0) {
            System.out.println("contact not found");
            return false;
        } else {
            this.mycontacts.remove(position);
            System.out.println("contact was deleted");
            return true;
        }
    }
        public void printcontacts () {
            for (int i = 0; i < mycontacts.size(); i++) {
                System.out.println((i + 1) + "." + mycontacts.get(i).getName() + "->" + mycontacts.get(i).getPhone());
            }
        }
    }


