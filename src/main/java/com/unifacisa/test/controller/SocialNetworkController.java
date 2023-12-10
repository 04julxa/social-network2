package com.unifacisa.test.controller;


import com.unifacisa.test.model.Post;
import com.unifacisa.test.model.User;
import com.unifacisa.test.repository.PostRepository;
import com.unifacisa.test.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SocialNetworkController {
    private final UserRepository repository1;
    private final PostRepository repository2;

    public SocialNetworkController (UserRepository repository1, PostRepository repository2) {
        this.repository1 = repository1; //user
        this.repository2 = repository2; //post


    }

    //list users
    @GetMapping("/listing_user")
    public String listUsers (Model model) {
        model.addAttribute("user" , new User());
        model.addAttribute("users", repository1.findAll());
        return "listing_user";
    }

    @PostMapping("/listing_user")
    public String newUser(@ModelAttribute User user, Model model) {
        repository1.save(user);
        return listUsers(model);
    }

    @GetMapping("/listing_post")
    public String listPosts (Model model) {
        model.addAttribute("post" , new Post());
        model.addAttribute("posts", repository1.findAll());
        return "listing post";
    }

    @PostMapping("/listing_post")
    public String newPost(@ModelAttribute Post post, Model model) {
        repository2.save(post);
        return listPosts(model);
    }

    @GetMapping
    public String index() {
        return login();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/posts")
    public String postagens() {
        return "posts";
    }

    @GetMapping("/new_post")
    public String newPost() {
        return "new_post";
    }

}










