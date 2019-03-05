package com.codeup.blog.controllers;

import com.codeup.blog.dao.Users;
import com.codeup.blog.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private Users users;
    //private PasswordEncoder passwordEncoder;

    public UserController(Users users) {
        this.users = users;
        //this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        //String hash = passwordEncoder.encode(user.getPassword());
//        try {
//            user.setPassword(hash);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        users.save(user);
        return "redirect:/login";
    }
}

