package com.example.greetingapp.services;

import com.example.greetingapp.dto.GreetingDto;
import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    GreetingRepository greetingRepository;

    public java.lang.String simpleHelloGreeting() {
        return "Hello World!";
    }

    public Greeting saveGreeting(GreetingDto greetingDto) {
        Greeting greeting = new Greeting();
        greeting.setMessage(greetingDto.getMessage());
        return greetingRepository.save(greeting);
    }

    public String findGreetingById(int id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            return "Found Greeting record with id: " + id;
        }
        return "Cannot find Greeting with given id: " + id;
    }
}
