package com.ncu.xzx.service;


import com.ncu.xzx.model.User;

public interface UserService {
    public User login(String userName, String password);

    int register(User user);

    User getUserById(int id);

    User getUserByUserName(String userName);
}
