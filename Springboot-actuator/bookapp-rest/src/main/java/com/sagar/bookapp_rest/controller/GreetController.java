package com.sagar.bookapp_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class GreetController {

    @GetMapping("/books")
    public List<String> getAll() {
        return Arrays.asList("Java", "Python", "C++");
    }

    @GetMapping("/greet/{username}")
    public String greetUser(@PathVariable String username) {
        return "Greet Day : "+username;
    }
}
