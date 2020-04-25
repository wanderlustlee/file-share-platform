package com.ncu.xzx.utils;

/**
 * Created by lichao.
 *
 * @date 2020/04/10 19:24
 * @description
 */
public class LoginContextUtil {
    public static int getUserId() {
        return LoginContext.get().getUserId();
    }
}
