package com.codeup.blog.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity @Table(name = "users")
public class User {

    public static final int MIN_PASSWORD_LEN = 8;
    public static final int MAX_PASSWORD_LEN = 32;
    public static final int MIN_USERNAME_LEN = 4;
    public static final int MAX_USERNAME_LEN = 32;
    public static final int MIN_EMAIL_LEN = 4;
    public static final int MAX_EMAIL_LEN = 128;

    @Transient
    private Pattern pattern;
    @Transient
    private Matcher matcher;
    @Transient
    private PasswordEncoder encoder;

    @Id @GeneratedValue
    private long id;
    @Column(nullable = false, length = MAX_USERNAME_LEN, unique = true)
    private String username;
    @Column(nullable = false, length = MAX_EMAIL_LEN, unique = true)
    private String email;
    @Column(nullable = false, length = MAX_PASSWORD_LEN)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    public User(){
        // for the spring db deserialization
    }

    public User(User copy) {
        try {
            this.setId(copy.id);
            this.setEmail(copy.email);
            this.setUsername(copy.username);
            this.setPassword(copy.password);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public User(String username, String email, String password)
            throws Exception
    {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        /* DEBUG */System.out.println("DEBUG: new User(...)");
    }

    public void setId(long id){
        if(id < 0){
            throw new NumberFormatException();
        }
        this.id = id;
    }

    public void setUsername(String username) throws Exception {
        this.pattern = Pattern.compile("[^A-Za-z0-9]");
        this.matcher = pattern.matcher(username);
        // TODO: write custom exceptions
        if(username.length() < MIN_USERNAME_LEN || username.length() > MAX_USERNAME_LEN){
            throw new Exception();
        }else if(matcher.find()){
            throw new Exception();
        }else{
            this.username = username;
        }
    }

    public void setEmail(String email) throws Exception {
        // TODO: convert this to regex
        // TODO: write custom exceptions
        if(email.length() < MIN_EMAIL_LEN || email.length() > MAX_EMAIL_LEN){
            throw new Exception();
        }else if(!email.contains("@")){
            throw new Exception();
        }else{
            this.email = email;
        }
    }

    public void setPassword(String password) throws Exception{
        if(password.length() < MIN_PASSWORD_LEN || password.length() > MAX_PASSWORD_LEN){
            throw new Exception();
        }else{
            this.password = encoder.encode(password);
        }
    }

    public void setPosts(List<Post> posts){
        if(posts == null){
            this.posts = new ArrayList<>(0);
        }else{
            this.posts = posts;
        }
    }

    public long getId(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){return this.password;}

    public List<Post> getPosts(){
        return this.posts;
    }
}
