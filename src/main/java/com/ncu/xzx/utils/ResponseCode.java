package com.ncu.xzx.utils;

public enum ResponseCode {

    OPERATION_SUCCESS(200, "操作成功"),
    OPERATION_ERROR(400, "操作失败");


    ResponseCode(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private int status;
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
