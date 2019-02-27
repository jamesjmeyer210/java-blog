package com.codeup.blog.models;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

@Entity @Table(name = "posts")
public class Post {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 64, unique = true)
    private String title;

    @Column(nullable = false, length = 2048)
    private String content;

    private List<Category> categories;

    // Constructor for putting objects in the db
    public Post(String title, String content, List<Category> categories){
        if(title == null || content == null || categories == null){
            throw new NullPointerException();
        }
        this.title = title;
        this.content = content;
        this.categories = categories;
    }

    // Constructor for removing objects from the db
    public Post(long id, String title, String content, List<Category> categories)
        throws NullPointerException
    {
        this(title, content, categories);
        this.id = id;
    }

    public long getId(){return this.id;}

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }

    public List<Category> getCategories(){
        return this.categories;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String description){
        this.content = description;
    }

    public void addCategory(Category ctgr){
        this.categories.add(ctgr);
    }

    public void removeCategory(Category ctgr){
        int index = this.categories.indexOf(ctgr);
        this.removeCategory(index);
    }

    public void removeCategory(int index){
        if(this.categories.size() < index){
            this.categories.remove(index);
        }
    }
}
