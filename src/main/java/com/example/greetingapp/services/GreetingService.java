package com.example.greetingapp.services;

import com.example.greetingapp.dto.GreetingDto;
import com.example.greetingapp.exceptions.GreetingException;
import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Greeting findGreetingById(int id) throws GreetingException {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            return greeting.get();
        }
        throw new GreetingException("Cannot find Greeting with given id: " + id);
    }

    public List<Greeting> listAllGreetings() throws GreetingException {
        List<Greeting> greetingList = greetingRepository.findAll();
        if (greetingList.isEmpty()) {
            throw new GreetingException("Cannot find any Greetings in List");
        }
        return greetingList;
    }

    public Greeting editGreeting(int id, GreetingDto greetingDto) throws GreetingException {
        Greeting greeting = this.findGreetingById(id);
        greeting.setMessage(greetingDto.getMessage());
        return greetingRepository.save(greeting);
    }
}
