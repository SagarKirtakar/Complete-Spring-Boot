package com.sagar.SpringSecExample.repository;

import com.sagar.SpringSecExample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Student, Integer> {
}
