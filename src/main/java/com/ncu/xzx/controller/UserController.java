package com.ncu.xzx.controller;

import com.ncu.xzx.model.*;
import com.ncu.xzx.service.*;
import com.ncu.xzx.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserTokenService userTokenService;

    @Autowired
    UserLoadService userLoadService;

    @Autowired
    FileService fileService;

    @Autowired
    PaperService paperService;


    @Autowired
    RedisTemplate redisTemplate; //默认提供的用来操作对象的redis操作实例

    @Autowired
    StringRedisTemplate stringRedisTemplate; //默认提供的用来操作字符串的redis操作实例

    @PassToken
    @PostMapping("/login")
    public Response login(String userName, String password) {
        String md5Password = MD5Util.md5(password);
        User user = userService.login(userName, md5Password);
        if (user == null) {
            return new Response(ResponseCode.OPERATION_ERROR.getStatus(), "用户名或密码错误");
        }
        String token = TokenUtil.getToken(user);
        userTokenService.addUserToken(user.getId(), token);
        ValueOperations ops = stringRedisTemplate.opsForValue();
        Object visitCountObject = ops.get("visitCount");
        if (visitCountObject == null) {
            ops.set("visitCount", "1");
        } else {
            Integer visitCount = Integer.valueOf(visitCountObject.toString());
            ops.set("visitCount", String.valueOf(visitCount + 1));
        }

        return new Response(token);
    }

    @PassToken
    @PostMapping("/register")
    public Response register(String userName, String password) {
        if (userName == null || password == null){
            return new Response(ResponseCode.OPERATION_ERROR.getStatus(), "字段为空");
        }
        User validateUser = userService.getUserByUserName(userName);
        if (validateUser != null) {
            return new Response(ResponseCode.OPERATION_ERROR.getStatus(), "用户名已被占用");
        }
        String md5Password = MD5Util.md5(password);
        User user = new User();
        user.setUserName(userName);
        user.setPassword(md5Password);

        int result = userService.register(user);
        if (result > 0) {
            ListOperations listOperations = redisTemplate.opsForList();
            try {
                listOperations.rightPush("userNameList", userName);
            }catch (Exception e) {
                e.printStackTrace();
            }
            String token = TokenUtil.getToken(user);
            userTokenService.addUserToken(user.getId(), token);
            return new Response(true);
        }
        return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "");
    }

    @PassToken
    @RequestMapping("/visit-count")
    public Response getVisitCount(){
        ValueOperations ops = stringRedisTemplate.opsForValue();
        Object visitCount = ops.get("visitCount");
        return new Response(visitCount);
    }

    @RequestMapping("/role")
    public Response getRole() {
        Role role = new Role();
        role.setName("admin");
        String[] roles = {"Home","Dashbord","Driver","Driver-index","Permission","PageUser","PageAdmin","Roles","Table","BaseTable","ComplexTable","Icons","Icons-index","Components","Sldie-yz","Upload","Carousel","Echarts","Sldie-chart","Dynamic-chart","Map-chart","Excel","Excel-out","Excel-in","Mutiheader-out","Error","Page404","Github","NavTest","Nav1","Nav2","Nav2-1","Nav2-2","Nav2-2-1","Nav2-2-2","*404"};
        role.setRoles(Arrays.asList(roles));
        role.setIntroduce("test");
        return new Response(role);
    }

    @GetMapping("/history")
    @UserLoginToken
    public Response getUserLoadHistory(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        UserToken userToken = userTokenService.getByToken(token);
        int userId = userToken.getUserId();
        List<FileDo> fileDoList = fileService.getByUserId(userId);
        List<FileVo> fileVoList = fileService.FileDoToFileVo(fileDoList);

        List<Paper> paperList = paperService.getPaperQuestionByUserId(userId);
        List<PaperVo> paperVoList = paperService.paperToPaperVo(paperList);

        UserHistory userHistory = new UserHistory(fileVoList, paperVoList);
        return new Response(userHistory);
    }

    @GetMapping("/validate")
    public Response validateUserName(@RequestParam("userName") String userName) {
        ListOperations listOperations = redisTemplate.opsForList();
        List<String> userNameList = listOperations.range("userNameList", 0, -1);
        System.out.println(userNameList.toString());
        for (int i = 0; i < userNameList.size(); i++) {
            if (userName.equals(userNameList.get(i))) {
                return new Response(false);
            }
        }
//        User user = userService.getUserByUserName(userName);
//        if (user == null) {
//            return new Response(true);
//        }
        return new Response(true);
    }
}
