package com.ncu.xzx.service;

import com.ncu.xzx.mapper.UserMapper;
import com.ncu.xzx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public int login(String userName, String password) {
        return userMapper.selectByUserNameAndPassword(userName, password);
    }

    @Override
    public int register(User user) {
        return userMapper.insert(user);
    }
}
