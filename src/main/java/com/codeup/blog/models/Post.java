package com.codeup.blog.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "posts")
public class Post {

    public static final int MIN_TITLE_LEN = 8;
    public static final int MAX_TITLE_LEN = 64;
    public static final int MIN_CONTENT_LEN = 256;
    public static final int MAX_CONTENT_LEN = 2048;

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 64, unique = true)
    private String title;

    @Column(nullable = false, length = 2048)
    private String content;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="posts_tags",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name="tag_id")}
    )
    private List<Tag> tags;

    public Post(){
        System.out.println("DEBUG: new Post()");
    }

    // Constructor for putting objects in the db
    public Post(String title, String content){
        if(title == null || content == null){
            throw new NullPointerException();
        }
        this.title = title;
        this.content = content;
        System.out.println("DEBUG: new Post(...)");
    }

    // Constructor for removing objects from the db
    public Post(long id, String title, String content)
        throws NullPointerException
    {
        this(title, content);
        this.id = id;
        System.out.println("DEBUG: new Post(...)");
    }

    public long getId(){return this.id;}

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }

    public User getUser() {
        return this.user;
    }

    public List<Tag> getTags(){
        return this.tags;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String description){
        this.content = description;
    }

    public void setTags(List<Tag> tags){
        if(tags == null){
            this.tags = new ArrayList<>(0);
        }else{
            this.tags = tags;
        }
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }

}
