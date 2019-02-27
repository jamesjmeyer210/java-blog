package com.codeup.blog.models;

import javax.persistence.*;

@Entity @Table(name = "categories")
public class Category {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 64, unique = true)
    private String name;

    // Constructor for putting objects in the db
    public Category(String name){
        if(name == null){
            throw new NullPointerException();
        }
        this.name = name;
    }

    // Constructor for removing objects from the db
    public Category(long id, String name)
        throws NullPointerException
    {
        this.id = id;
        this.name = name;
    }

    public long getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
