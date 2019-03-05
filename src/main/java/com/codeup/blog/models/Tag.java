package com.codeup.blog.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "tags")
public class Tag {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 64, unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;

    // Constructor for putting objects in the db
    public Tag(String name){
        if(name == null){
            throw new NullPointerException();
        }
        this.name = name;
    }

    // Constructor for removing objects from the db
    public Tag(long id, String name)
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

    public List<Post> getPost(){
        return this.posts;
    }

    public void setPosts(List<Post> posts){
        if(posts == null){
            this.posts = new ArrayList<>(0);
        }else{
            this.posts = posts;
        }
    }

    public void addPost(Post post){
        this.posts.add(post);
    }
}
