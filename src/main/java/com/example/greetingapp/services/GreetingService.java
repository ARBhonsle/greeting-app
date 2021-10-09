package com.example.greetingapp.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String simpleHelloGreeting(){
        return "Hello World!";
    }
}
