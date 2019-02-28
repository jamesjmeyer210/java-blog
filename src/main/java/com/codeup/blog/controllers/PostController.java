package com.codeup.blog.controllers;

import com.codeup.blog.dao.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository pd){
        this.postDao = pd;
    }

    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
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
