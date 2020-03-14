package com.ncu.xzx.service;

import com.ncu.xzx.model.UserToken;

public interface UserTokenService {
    UserToken getByToken(String token);

    int addUserToken(int userId, String token);
}
