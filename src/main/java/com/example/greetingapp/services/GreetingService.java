package com.example.greetingapp.services;

import com.example.greetingapp.dto.GreetingDto;
import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    
    @Autowired
    GreetingRepository greetingRepository;

    public String simpleHelloGreeting(){
        return "Hello World!";
    }
    
    public Greeting saveMessage(GreetingDto greetingDto){
        Greeting greeting = new Greeting();
        greeting.setMessage(greetingDto.getMessage());
        return greetingRepository.save(greeting);
    }
}
