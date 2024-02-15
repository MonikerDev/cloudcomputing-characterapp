package com.moniker.ccbase.controllers;

import com.azure.core.annotation.Get;
import com.azure.core.annotation.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping ("/test")
@Controller
public class TestController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/aternate")
    @ResponseBody
    public String alternateIndex(){
        return "Alternate greetins hehe";
    }

    @GetMapping("/testForm")
    public String showTestForm(){
        return "testForm.html";
    }

    @GetMapping("/testFormResponse")
    @ResponseBody
    public String formResponse(@RequestParam String formInput){
        return String.format("Input: %s", formInput);
    }
}
