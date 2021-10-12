package com.example.greetingapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * GreetingDto
 * services access greeting details using dto
 * @author Aditi
 * @version 0.0.1
 * @since 12-10-2021
 */
@Getter
@Setter
@Data
public class GreetingDto {
    private String message;
}
