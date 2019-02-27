package com.codeup.blog.models;

public class Category {

    private String name;

    public Category(String name){
        if(name == null){
            throw new NullPointerException();
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
