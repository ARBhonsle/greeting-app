package com.example.greetingapp.exceptions;

/**
 * GreetingException throws exceptions
 * @author Aditi
 * @version 0.0.1
 * @since 12-10-2021
 */
public class GreetingException extends RuntimeException {
    public GreetingException(String message) {
        super(message);
    }
}
