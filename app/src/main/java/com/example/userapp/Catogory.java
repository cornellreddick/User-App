package com.example.userapp;


import java.util.ArrayList;

public class Catogory {

    String category;

    public static ArrayList<String> getCategories()    {
        ArrayList<String> cat = new ArrayList<String>();
        cat.add("Age");
        cat.add("Name");
        cat.add("State");
        return(cat);
    }

    public Catogory(String category) {
        this.category = category;
    }
}
