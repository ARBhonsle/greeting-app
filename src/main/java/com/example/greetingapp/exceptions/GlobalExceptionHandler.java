package com.example.greetingapp.exceptions;

import com.example.greetingapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalExceptionHandler handles exception thrown by service methods
 * @author Aditi
 * @version 0.0.1
 * @since 12-10-2021
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     *  method handles exceptions from services used during operation of http requests from clients
     * @param exception thrown by service methods
     * @return
     */
    @ExceptionHandler(value = GreetingException.class)
    public ResponseEntity<ResponseDto> handleGreetingException(GreetingException exception){
        return new ResponseEntity<ResponseDto>(new ResponseDto(exception.getMessage(),null),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ResponseDto> handleValidationException (ValidationException exception){
        return new ResponseEntity<ResponseDto>(new ResponseDto(exception.getMessage(),null),HttpStatus.METHOD_NOT_ALLOWED);
    }

}
