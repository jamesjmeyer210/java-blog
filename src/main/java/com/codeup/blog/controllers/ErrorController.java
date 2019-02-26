package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

    //@GetMapping("/404")
    @RequestMapping(value = "404Error", method = RequestMethod.GET)
    public String notFound(){
        // DEBUG
        System.out.println("DEBUG: ErrorController\n"
            + "\tnotFound()");
        // END DEBUG
        return "error/404";
    }

}
