package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String posts(){
        return "Viewing all posts";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String posts(@PathVariable int id){
        return "Viewing post: " + id;
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String create(){
        return "Viewing create";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestParam(name = "submit") String submit){
        return "Creating a post..." + submit;
    }

}
