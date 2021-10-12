package com.example.greetingapp.exceptions;

/**
 * ValidationException handles exception thrown due to validation in methods
 * @author Aditi
 * @version 0.0.1
 * @since 12-10-2021
 */
public class ValidationException extends RuntimeException {

    ValidationException(String message){
        super(message);
    }
}
