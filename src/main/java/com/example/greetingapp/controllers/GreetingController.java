package com.example.greetingapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/")
    public String greeting() {
        return "Hello! Welcome to Greeting App!";
    }

    @GetMapping("/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello " + name + "! Welcome to Greeting App!";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname) {
        return "Hello " + fname + " " + lname +"! Welcome to Greeting App!";
    }


}
