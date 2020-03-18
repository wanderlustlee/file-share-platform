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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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

    @Autowired
    RedisTemplate redisTemplate; //默认提供的用来操作对象的redis操作实例

    @Autowired
    StringRedisTemplate stringRedisTemplate; //默认提供的用来操作字符串的redis操作实例

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

    @PassToken
    @RequestMapping("/get-visit-count")
    public Response getVisitCount(){
        ValueOperations ops = stringRedisTemplate.opsForValue();
        Object visitCount = ops.get("visitCount");
        return new Response(visitCount);
    }
}
