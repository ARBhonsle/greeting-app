package com.example.greetingapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Greeting
 * stores greeting details
 * @author Aditi
 * @version 0.0.1
 * @since 12-10-2021
 */
@Entity
@Data
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;

}
