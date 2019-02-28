package com.codeup.blog.controllers;

import com.codeup.blog.dao.PostRepository;
import com.codeup.blog.models.Post;
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
    public String posts(@PathVariable long id, Model model){
        Post post = postDao.findOne(id);
        if(post == null){
            return "error/404";
        }
        model.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("MIN_TITLE_LEN", Post.MIN_TITLE_LEN);
        model.addAttribute("MAX_TITLE_LEN", Post.MAX_TITLE_LEN);
        model.addAttribute("MIN_CONTENT_LEN", Post.MIN_CONTENT_LEN);
        model.addAttribute("MAX_CONTENT_LEN", Post.MAX_CONTENT_LEN);
        return "posts/create";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(name = "title") String title,
                         @RequestParam(name = "content") String content)
    {
        // DEBUG
        System.out.println("DEBUG: create(...)");
        // END DEBUG
        try {
            // The following checks should prevent any exceptions from being thrown
            if(title.length() <= Post.MIN_TITLE_LEN || title.length() >= Post.MAX_TITLE_LEN)
            {
                // DEBUG
                System.out.println("\tDEBUG: title length out of bounds.");
                // END DEBUG
                return "redirect:/create";
            }else if(content.length() <= Post.MIN_CONTENT_LEN || content.length() >= Post.MAX_CONTENT_LEN) {
                // DEBUG
                System.out.println("\tDEBUG: content length out of bounds.");
                // END DEBUG
                return "redirect:/create";
            }
            Post post = new Post(title, content);
            this.postDao.save(post);
        } catch(NullPointerException e){
            e.printStackTrace();
            return "redirect:/create";
        }

        return "redirect:/posts";
    }

}
