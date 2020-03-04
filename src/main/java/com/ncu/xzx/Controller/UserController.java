package com.ncu.xzx.Controller;

import com.ncu.xzx.Utils.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/login")
    public Response login(String userName, String password) {

        return new Response();
    }
}
