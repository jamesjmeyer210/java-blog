package com.codeup.blog.controllers;

import com.codeup.blog.dao.PostRepository;
import com.codeup.blog.dao.TagRepository;
import com.codeup.blog.dao.UserRepository;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final TagRepository tagDao;
    private final UserRepository userDao;

    @Autowired
    private final EmailService emailService;

    public PostController(PostRepository pd, TagRepository td, UserRepository ud, EmailService es){
        this.postDao = pd;
        this.tagDao = td;
        this.userDao = ud;
        this.emailService = es;
    }

    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String posts(@PathVariable long id, Model model){
        Post post = postDao.findOne(id);
        if(post == null){
            return "error/404";
        }
        model.addAttribute("post", post);
        return "posts/show";
    }

    private Model addPostConstants(Model model){
        model.addAttribute("MIN_TITLE_LEN", Post.MIN_TITLE_LEN);
        model.addAttribute("MAX_TITLE_LEN", Post.MAX_TITLE_LEN);
        model.addAttribute("MIN_CONTENT_LEN", Post.MIN_CONTENT_LEN);
        model.addAttribute("MAX_CONTENT_LEN", Post.MAX_CONTENT_LEN);
        return model;
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model = addPostConstants(model);

        return "posts/create";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "title") String title,
                         @RequestParam(name = "content") String content)
    {
        /* DEBUG */System.out.println("DEBUG: create(...)");
        try {
            // The following checks should prevent any exceptions from being thrown
            if(title.length() <= Post.MIN_TITLE_LEN || title.length() >= Post.MAX_TITLE_LEN) {
                /* DEBUG */System.out.println("\tDEBUG: title length out of bounds.");
                return "redirect:/create";
            }else if(content.length() <= Post.MIN_CONTENT_LEN || content.length() >= Post.MAX_CONTENT_LEN) {
                /* DEBUG */System.out.println("\tDEBUG: content length out of bounds.");
                return "redirect:/create";
            }
            Post post = new Post(title, content);
            this.postDao.save(post);
            // TODO: user value is currently hardcoded
            /* DEBUG */System.out.println("DEBUG: post saved to database.");
//            User admin = new User(
//                    "admin",
//                    "9b0989da44-2970db@inbox.mailtrap.io",
//                    "password123"
//            );
            User admin = userDao.findOne(1L);
            emailService.prepareAndSend(
                    admin,
                    "New Post: " + title,
                    "You created a new post on " + new Date().getTime() + ".\n"
            );
        } catch(NullPointerException e){
            e.printStackTrace();
            return "redirect:/create";
        } catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/posts";
    }

    @RequestMapping(path = "/posts/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable long id, Model model){

        if(!postDao.exists(id)){
            /* DEBUG */System.out.println("DEBUG: post of id " + id + " does not exist.");
            return "redirect:/error/404";
        }

        Post post = postDao.findOne(id);
        model = addPostConstants(model);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping(path = "/posts/edit/{id}")
    public String edit(@PathVariable long id, @RequestParam String title, @RequestParam String content) {

        /* DEBUG */System.out.println("DEBUG: edit(...)");
        // The following checks should prevent any exceptions from being thrown
        if(title.length() <= Post.MIN_TITLE_LEN || title.length() >= Post.MAX_TITLE_LEN) {
            /* DEBUG */System.out.println("DEBUG: Title length out of bounds.");
            return "redirect:/posts/edit/" + id;
        }else if(content.length() <= Post.MIN_CONTENT_LEN || content.length() >= Post.MAX_CONTENT_LEN) {
            /* DEBUG */System.out.println("DEBUG: Content length out of bounds.");
            return "redirect:/posts/edit/" + id;
        }else if(!postDao.exists(id)){
            /* DEBUG */System.out.println("DEBUG: id (" + id + ") does not exist.");
            return "redirect:/error/404";
        }
        // catch a null pointer exception from the Post constructor
        try{
            Post post = new Post(title, content);
            postDao.delete(id);
            this.postDao.save(post);
        } catch(NullPointerException e) {
            e.printStackTrace();
            return "redirect:/posts/edit/" + id;
        }
        /* DEBUG */System.out.println("DEBUG: redirecting to /posts/" + id);
        return "redirect:/posts/" + id;
    }

    @RequestMapping(path = "/posts/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id){
        if(postDao.findOne(id) == null){
            return "redirect:/error/404";
        }
        postDao.delete(id);
        return "redirect:/posts";
    }

}
