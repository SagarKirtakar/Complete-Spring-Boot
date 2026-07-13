package com.sagar.SpringSecExample.services;

import com.sagar.SpringSecExample.model.UserPrinciple;
import com.sagar.SpringSecExample.model.Users;
import com.sagar.SpringSecExample.repository.UserRepo;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Users user = userRepo.findByUsername(username);
       if (user == null) {
           System.out.println("User not found");
           throw new UsernameNotFoundException("User not found");
       }
        return new UserPrinciple(user);
    }
}
