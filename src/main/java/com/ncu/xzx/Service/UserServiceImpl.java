package com.ncu.xzx.Service;

import com.ncu.xzx.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public int login(String userName, String password) {
        return 0;
    }
}
