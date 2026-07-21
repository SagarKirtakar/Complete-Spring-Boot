package com.sagar.Github_cicd_actions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello Github-Actions";
    }

}
