package com.sagar.RegisterLoginApp.services;

import com.sagar.RegisterLoginApp.model.Users;

public interface UserService {

    Users register(Users user);

    String verify(Users user);

}
