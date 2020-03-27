package com.ncu.xzx.utils;

import org.springframework.util.DigestUtils;

import java.util.Random;

public class MD5Util {

    //密码加密
    public static String md5(String password) {
//        String salt = random(5); // 随机盐值，生成几位的验证码
        String salt = "bear";
        String newPassword = password + salt;
        return DigestUtils.md5DigestAsHex(newPassword.getBytes());
    }
    //salt 生成
    private static String random(int mu){
        Random random = new Random();
        String chars = "qazwsxedcrfvtgbyhnujmikolp";
        String returns = "";
        for(int i = 0 ; i < mu ;i ++ ){
            returns += chars.charAt(random.nextInt(chars.length()));
        }
        return returns;
    }

}