package com.userservice.UserService.services;

import com.userservice.UserService.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUser(String userId);
}
