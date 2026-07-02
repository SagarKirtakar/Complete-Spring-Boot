package com.sagar.SpringbootRestfulWs.services;

import com.sagar.SpringbootRestfulWs.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User crateUser(User user);

    public List<User> getAllUser();

    public Optional<User> getUserById(int id);

    public User updateUserById(int id, User user);

    public void deleteUser(int id);
}
