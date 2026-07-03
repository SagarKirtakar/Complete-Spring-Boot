package com.sagar.SpringSecExample.controller;

import com.sagar.SpringSecExample.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(101, "Saga", 60),
            new Student(102, "kunla", 50)
    ));

    @GetMapping("/getAllStd")
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping("/addStd")
    public void addStudent(@RequestBody Student std) {
        students.add(std);
    }

    @GetMapping("/getcsrfToken")
    public CsrfToken csrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
