package com.ncu.xzx.controller;

import com.ncu.xzx.model.User;
import com.ncu.xzx.service.UserService;
import com.ncu.xzx.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Response login(String userName, String password) {
        int result = userService.login(userName, password);
        return new Response(result);
    }

    @PostMapping("/register")
    public Response register(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        int result = userService.register(user);
        return new Response(result);
    }
}
