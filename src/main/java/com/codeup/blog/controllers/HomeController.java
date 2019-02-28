package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        // DEBUG
        System.out.println("DEBUG: HomeController\n"
            + "\tindex()");
        // END DEBUG
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "redirect:/resume";
    }

    @GetMapping("/resume")
    public String resume(){
        return "site/resume";
    }
}
