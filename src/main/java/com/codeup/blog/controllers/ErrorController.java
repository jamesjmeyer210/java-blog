package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/404")
    public String notFound(){
        // DEBUG
        System.out.println("DEBUG: ErrorController\n"
            + "\tnotFound()");
        // END DEBUG
        return "error/404";
    }

}
