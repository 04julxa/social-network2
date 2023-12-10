package com.unifacisa.test.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer Id;
    private String name;
    private String password;

    @OneToMany
    private List<Post> posts;

    public User(){
        this.posts = new ArrayList<>();
    }
    //add posts
    public void addPost(Post post){
        posts.add(post);
        post.setAuthor(this);
    }
    //remove posts
    public void removePost (Post post){
        posts.remove(post);
        post.setAuthor(null);
    }

    // getters and setters
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
