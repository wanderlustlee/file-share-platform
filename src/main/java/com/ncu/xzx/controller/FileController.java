package com.ncu.xzx.controller;

import com.ncu.xzx.model.UserToken;
import com.ncu.xzx.service.UserTokenService;
import com.ncu.xzx.utils.Response;
import com.ncu.xzx.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    UserTokenService userTokenService;

    @PostMapping("/upload")
    @UserLoginToken
    public Response upload(@RequestParam("token") String token, @RequestParam("file") MultipartFile file) {

        UserToken userToken = userTokenService.getByToken(token);
        int userId = userToken.getUserId();

        return new Response(userId);
    }
}
