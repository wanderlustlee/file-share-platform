package com.ncu.xzx.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ncu.xzx.model.User;
import com.ncu.xzx.model.UserToken;
import com.ncu.xzx.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;

public class TokenUtil {

    public static String getToken(User user) {
        String token="";
        System.out.println(user.toString());
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
