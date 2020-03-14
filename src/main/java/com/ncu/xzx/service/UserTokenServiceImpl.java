package com.ncu.xzx.service;

import com.ncu.xzx.mapper.UserTokenMapper;
import com.ncu.xzx.model.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenServiceImpl implements UserTokenService{

    @Autowired
    UserTokenMapper userTokenMapper;

    @Override
    public UserToken getByToken(String token) {
        return userTokenMapper.getByToken(token);
    }

    @Override
    public int addUserToken(int userId, String token) {
        return userTokenMapper.addUserToken(userId, token);
    }
}
