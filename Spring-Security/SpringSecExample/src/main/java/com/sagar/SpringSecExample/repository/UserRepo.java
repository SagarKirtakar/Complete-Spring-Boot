package com.sagar.SpringSecExample.repository;

import com.sagar.SpringSecExample.model.Student;
import com.sagar.SpringSecExample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}
