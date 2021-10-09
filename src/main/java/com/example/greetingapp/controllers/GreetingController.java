package com.example.greetingapp.controllers;

import com.example.greetingapp.dto.GreetingDto;
import com.example.greetingapp.exceptions.GreetingException;
import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping("/")
    public java.lang.String greeting() {
        return "Hello! Welcome to Greeting App!";
    }

    @GetMapping("/greeting-param/{name}")
    public java.lang.String greeting(@PathVariable java.lang.String name) {
        return "Hello " + name + "! Welcome to Greeting App!";
    }

    @GetMapping("/greeting")
    public java.lang.String greeting(@RequestParam(value = "fname") java.lang.String fname, @RequestParam(value = "lname") java.lang.String lname) {
        return "Hello " + fname + " " + lname + "! Welcome to Greeting App!";
    }

    @GetMapping("/greeting-service")
    public java.lang.String greetingService() {
        return greetingService.simpleHelloGreeting();
    }

    @GetMapping("/greeting-message/{name}")
    public java.lang.String greetingMessage(@PathVariable java.lang.String name, @RequestParam(required = false, value = "param") java.lang.String param, @RequestParam(required = false, value = "param1") java.lang.String param1) {
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
    public Greeting saveGreeting(@RequestBody GreetingDto greetingDto) {
        return greetingService.saveGreeting(greetingDto);
    }

    @GetMapping("/greetingMessage/{id}")
    public Optional<Greeting> findGreetingById(@PathVariable int id) throws GreetingException {
        return greetingService.findGreetingById(id);
    }

    @GetMapping("/greetingMessage/findAll")
    public List<Greeting> findAllGreetings() throws GreetingException {
        return greetingService.listAllGreetings();
    }

}
