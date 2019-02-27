package com.codeup.blog.models;

import javax.persistence.*;

@Entity @Table(name = "categories")
public class Category {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 64, unique = true)
    private String name;

    public Category(String name){
        if(name == null){
            throw new NullPointerException();
        }
        this.name = name;
    }

    public Category(long id, String name)
        throws NullPointerException
    {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
