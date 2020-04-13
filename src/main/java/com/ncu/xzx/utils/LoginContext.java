package com.ncu.xzx.utils;

/**
 * Created by lichao.
 *
 * @date 2020/04/10 19:25
 * @description
 */
public class LoginContext {
    public static final ThreadLocal<Context> THREAD_LOCAL_CONTEXT = new ThreadLocal<Context>();

    public static Context get() {
        return THREAD_LOCAL_CONTEXT.get();
    }

    public static void set(Context context) {
        THREAD_LOCAL_CONTEXT.set(context);
    }

}
