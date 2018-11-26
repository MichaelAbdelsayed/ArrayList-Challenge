package com.company;

public class contacts {
    private String name ;
    private String phone ;

    public contacts (String name ,String phone) {
        this.name=name ;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
    public static  contacts createcontact(String name , String phone){
        return new contacts(name , phone);
    }
}



