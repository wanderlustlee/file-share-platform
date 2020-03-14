package com.ncu.xzx.controller;

import com.alibaba.fastjson.JSONObject;
import com.ncu.xzx.model.User;
import com.ncu.xzx.service.UserService;
import com.ncu.xzx.service.UserTokenService;
import com.ncu.xzx.utils.PassToken;
import com.ncu.xzx.utils.Response;
import com.ncu.xzx.utils.TokenUtil;
import com.ncu.xzx.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserTokenService userTokenService;

    @PassToken
    @PostMapping("/login")
    public Response login(String userName, String password) {
        User user = userService.login(userName, password);
        String token = TokenUtil.getToken(user);
        userTokenService.addUserToken(user.getId(), token);
        return new Response(true);
    }

    @PassToken
    @PostMapping("/register")
    public Response register(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        int result = userService.register(user);
        if (result > 0) {
            String token = TokenUtil.getToken(user);
            userTokenService.addUserToken(user.getId(), token);
            return new Response(true);
        }
        return new Response(false);
    }

    @UserLoginToken
    @RequestMapping("/getMessage")
    public String getMessage(String token){
        return token;
    }
}
