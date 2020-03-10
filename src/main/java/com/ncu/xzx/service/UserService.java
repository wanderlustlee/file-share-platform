package com.ncu.xzx.service;


import com.ncu.xzx.model.User;

public interface UserService {
    public int login(String userName, String password);

    int register(User user);
}
