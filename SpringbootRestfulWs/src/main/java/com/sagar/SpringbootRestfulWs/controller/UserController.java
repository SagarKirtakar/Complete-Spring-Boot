package com.sagar.SpringbootRestfulWs.controller;

import com.sagar.SpringbootRestfulWs.entity.User;
import com.sagar.SpringbootRestfulWs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public User addUserDetails(@RequestBody User user) {
        return userService.crateUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable int id) {
        User user = userService.getUserById(id).orElse(null);
        if(user != null) {
           return ResponseEntity.ok().body(user);
        }else {
           return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id) {
      User validUser =  userService.updateUserById(id, user);
      if(validUser != null) {
       return ResponseEntity.ok().body(validUser);
      }else {
        return ResponseEntity.notFound().build();
      }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        User validUser = userService.getUserById(id).orElse(null);
        if(validUser != null) {
            userService.deleteUser(id);
            return ResponseEntity.ok().body("User deleted successfully");
        }else {
            return ResponseEntity.ok().body("User not delete due to some error");
        }

    }

}
