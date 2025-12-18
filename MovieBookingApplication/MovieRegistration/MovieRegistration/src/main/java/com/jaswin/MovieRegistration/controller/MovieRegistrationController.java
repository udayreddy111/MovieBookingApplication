package com.jaswin.MovieRegistration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRegistrationController {

    @GetMapping
    String testMessage() {
        return "hi iam working fine";
        
    }
    @PostMapping
    String testMessage1() {
        return "hi iam working fine";
        
    }
}
