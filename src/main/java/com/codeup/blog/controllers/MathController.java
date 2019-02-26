package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    private String integerError(){
        return "Please enter an integer less than " + Integer.MAX_VALUE
                + "and greater than " + Integer.MIN_VALUE;
    }

    @GetMapping("/add/{a}/and/{b}")
    @ResponseBody
    public String add(@PathVariable String a, @PathVariable String b){
        try {
            int intA = Integer.parseInt(a);
            int intB = Integer.parseInt(b);
            return "" + (intA + intB);
        } catch (NumberFormatException e){
            return integerError();
        }
    }

    @GetMapping("/sub/{a}/from/{b}")
    @ResponseBody
    public String sub(@PathVariable String a, @PathVariable String b){
        try {
            int intA = Integer.parseInt(a);
            int intB = Integer.parseInt(b);
            return "" + (intA - intB);
        } catch (NumberFormatException e){
            return integerError();
        }
    }

    @GetMapping("/mul/{a}/and/{b}")
    @ResponseBody
    public String mul(@PathVariable String a, @PathVariable String b){
        try {
            int intA = Integer.parseInt(a);
            int intB = Integer.parseInt(b);
            return "" + (intA * intB);
        } catch (NumberFormatException e){
            return integerError();
        }
    }

    @GetMapping("/div/{a}/by/{b}")
    @ResponseBody
    public String div(@PathVariable String a, @PathVariable String b){
        try {
            int intA = Integer.parseInt(a);
            int intB = Integer.parseInt(b);
            return "" + (intA / intB);
        } catch (NumberFormatException e){
            return integerError();
        }
    }

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }

    @RequestMapping(path = "/roll-dice", method = RequestMethod.POST)
    public String rollDice(@RequestParam(name = "guess") int guess, Model model){
        model.addAttribute("guess", guess);
        return "roll-dice";
    }

}
