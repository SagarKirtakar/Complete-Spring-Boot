package com.sagar.SpringbootRestfulWs.services;

import com.sagar.SpringbootRestfulWs.entity.User;
import com.sagar.SpringbootRestfulWs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User crateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUserById(int id, User user) {
      User validUser =  userRepository.findById(id).orElse(null);
      if (validUser != null) {
         return userRepository.save(user);
      }else {
          throw new RuntimeException("User not found : "+id);
      }
    }

    @Override
    public void deleteUser(int id) {
       User validUser =  userRepository.findById(id).orElse(null);
       if(validUser != null) {
           userRepository.deleteById(id);
       }else {
           throw new RuntimeException("User not found : "+id);
       }
    }


}
