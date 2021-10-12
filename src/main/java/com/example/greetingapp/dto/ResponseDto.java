package com.example.greetingapp.dto;

import lombok.Data;

/**
 * ResponseDto
 * services stores method response into this and return using ResponseEntity
 */
@Data
public class ResponseDto {
    private String message;
    private Object data;

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}
