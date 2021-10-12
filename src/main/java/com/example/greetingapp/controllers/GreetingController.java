package com.example.greetingapp.controllers;

import com.example.greetingapp.dto.GreetingDto;
import com.example.greetingapp.dto.ResponseDto;
import com.example.greetingapp.exceptions.GreetingException;
import com.example.greetingapp.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.String;

/**
 * Greeting Controller
 * recieves http request from client and perform functions and give response to clients
 *
 * @author Aditi
 * @version 0.0.1
 * @since 12-10-2021
 */
@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    /**
     * method accepts GET http request from clients and responds with simple greeting
     *
     * @return
     */
    @GetMapping("/")
    public String greeting() {
        return "Hello! Welcome to Greeting App!";
    }

    /**
     * method accepts parameters from url path of http request from clients
     *
     * @param name from url path
     * @return String
     */
    @GetMapping("/greeting-param/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello " + name + "! Welcome to Greeting App!";
    }

    /**
     * method to accept fname and lname from url path of http request and gives response
     *
     * @param fname from url path
     * @param lname from url path
     * @return ResponseEntity<ResponseDto>
     */
    @GetMapping("/greeting")
    public ResponseEntity<ResponseDto> greeting(@RequestParam(value = "fname") String fname, @RequestParam(value = "lname") String lname) {
        ResponseDto respDto = new ResponseDto("Hello " + fname + " " + lname + "! Welcome to Greeting App!", null);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    /**
     *
     * @return ResponseEntity<ResponseDto>
     */
    @GetMapping("/greeting-service")
    public ResponseEntity<ResponseDto> greetingService() {
        ResponseDto respDto = new ResponseDto(greetingService.simpleHelloGreeting("", "", ""), null);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    /**
     *
     * @param name from url path of request
     * @param param from request query parameters
     * @param param1 from request query parameters
     * @return ResponseEntity<ResponseDto>
     */
    @GetMapping("/greeting-message/{name}")
    public ResponseEntity<ResponseDto> greetingMessage(@PathVariable String name, @RequestParam(required = false, value = "param") String param, @RequestParam(required = false, value = "param1") String param1) {
        ResponseDto respDto = new ResponseDto(greetingService.simpleHelloGreeting(name, param, param1), null);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    /**
     *
     * @param greetingDto from request body
     * @return ResponseEntity<ResponseDto>
     */
    @PostMapping("/greetingMessage")
    public ResponseEntity<ResponseDto> saveGreeting(@RequestBody GreetingDto greetingDto) {
        ResponseDto respDto = new ResponseDto("Greeting Saved", greetingService.saveGreeting(greetingDto));
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    /**
     *
     * @param id from url path of request
     * @return ResponseEntity<ResponseDto>
     * @throws GreetingException
     */
    @GetMapping("/greetingMessage/{id}")
    public ResponseEntity<ResponseDto> findGreetingById(@PathVariable int id) throws GreetingException {
        ResponseDto respDto = new ResponseDto("Greeting Found by id: " + id, greetingService.findGreetingById(id));
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    /**
     *
     * @return ResponseEntity<ResponseDto>
     * @throws GreetingException
     */
    @GetMapping("/greetingMessage/findAll")
    public ResponseEntity<ResponseDto> findAllGreetings() throws GreetingException {
        ResponseDto respDto = new ResponseDto("Found all greeting", greetingService.listAllGreetings());
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    /**
     *
     * @param id from url path of request
     * @param greetingDto from request body
     * @return ResponseEntity<ResponseDto>
     * @throws GreetingException
     */
    @PutMapping("/greetingMessage/{id}")
    public ResponseEntity<ResponseDto> editGreeting(@PathVariable int id, @RequestBody GreetingDto greetingDto) throws GreetingException {
        ResponseDto respDto = new ResponseDto("Updated greeting with id: " + id, greetingService.editGreeting(id, greetingDto));
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    /**
     *
     * @param id from url path of request
     * @return ResponseEntity<ResponseDto>
     * @throws GreetingException
     */
    @DeleteMapping("/greetingMessage/{id}")
    public ResponseEntity<ResponseDto> deleteMessage(@PathVariable int id) throws GreetingException {
        ResponseDto respDto = new ResponseDto("Deleted greeting with id: " + id, greetingService.deleteGreeting(id));
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }
}
