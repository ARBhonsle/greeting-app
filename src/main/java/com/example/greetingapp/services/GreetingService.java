package com.example.greetingapp.services;

import com.example.greetingapp.dto.GreetingDto;
import com.example.greetingapp.exceptions.GreetingException;
import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.repository.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.lang.String;

/**
 * Greeting Service
 *  services used by Greeting controller to perform and give response to client http requests
 *
 * @author Aditi
 * @version 0.0.1
 * @since 12-10-2021
 */
@Service
public class GreetingService {

    @Autowired
    GreetingRepository greetingRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * GreetingService has all methods used by Greeting Controller
     * @author Aditi
     * @version 0.0.1
     * @since 12-10-2021
     */
    public String simpleHelloGreeting(String name,String param,String param1) {
        StringBuilder string = new StringBuilder();
        string.append("Hello World! ");
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

    /**
     * method which saves greeting
     * @param greetingDto
     * @return Greeting
     */
    public Greeting saveGreeting(GreetingDto greetingDto) {
        Greeting greeting = new Greeting();
        modelMapper.map(greetingDto,greeting);
        return greetingRepository.save(greeting);
    }

    /**
     * method which finds greeting by id
     * @param id
     * @return Greeting
     */
    public Greeting findGreetingById(int id) throws GreetingException {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            return greeting.get();
        }
        throw new GreetingException("Cannot find Greeting with given id: " + id);
    }

    /**
     * method which lists all greetings
     * @return list of Greetings
     */
    public List<Greeting> listAllGreetings() throws GreetingException {
        List<Greeting> greetingList = greetingRepository.findAll();
        if (greetingList.isEmpty()) {
            throw new GreetingException("Cannot find any Greetings in List");
        }
        return greetingList;
    }

    /**
     * method which can update greeting with given id
     * @param id
     * @param greetingDto
     * @return Greeting
     */
    public Greeting editGreeting(int id, GreetingDto greetingDto) throws GreetingException {
        Greeting greeting = this.findGreetingById(id);
        modelMapper.map(greetingDto,greeting);
        return greetingRepository.save(greeting);
    }

    /**
     *  method which deletes greeting with given id
     * @param id
     * @return String
     */
    public String deleteGreeting(int id) throws GreetingException {
        Greeting greeting = this.findGreetingById(id);
        greetingRepository.delete(greeting);
        return "Greeting with id: " + id + " is deleted successfully";
    }
}
