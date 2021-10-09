package com.example.greetingapp.controllers;

import com.example.greetingapp.dto.GreetingDto;
import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping("/")
    public String greeting() {
        return "Hello! Welcome to Greeting App!";
    }

    @GetMapping("/greeting-param/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello " + name + "! Welcome to Greeting App!";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname) {
        return "Hello " + fname + " " + lname + "! Welcome to Greeting App!";
    }

    @GetMapping("/greeting-service")
    public String greetingService() {
        return greetingService.simpleHelloGreeting();
    }

    @GetMapping("/greeting-message/{name}")
    public String greetingMessage(@PathVariable String name, @RequestParam(required = false, value = "param") String param, @RequestParam(required = false, value = "param1") String param1) {
        StringBuilder string = new StringBuilder();
        string.append(greetingService.simpleHelloGreeting());
        if (!name.isBlank()) {
            string.append(" " + name);
        }
        if (!param.isBlank()) {
            string.append(" and " + param);
        }
        if (!param1.isBlank()) {
            string.append(" " + param1);
        }
        return string.toString();
    }

    @PostMapping("/greetingMessage")
    public Greeting saveGreeting(@RequestBody GreetingDto greetingDto){
        return greetingService.saveMessage(greetingDto);
    }

}
