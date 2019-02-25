package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return "<div>This is the landing page!</div>";
    }

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name){
//        return "<h1>Hello " + name + "</h1>";
//    }

}
