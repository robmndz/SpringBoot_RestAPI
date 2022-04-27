package com.example.springrestapi.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("Welcome to the program!")
    private String welcomeMessage;

    // http://localhost:8082/api/
    @GetMapping("/")
    public String helloWorld() {
        return welcomeMessage;

    }
}
