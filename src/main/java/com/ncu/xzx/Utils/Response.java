package com.ncu.xzx.Utils;

public class Response {


    //响应业务状态码
    private Integer status;

    //响应信息
    private String msg;

    //响应数据
    private Object data;
    public Response(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Response(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static Response build(Integer status, String msg,Object data) {
        return new Response(status, msg, data);
    }

    public static Response build(Integer status, String msg) {
        return new Response(status, msg, null);
    }


    public static Response ok(Object data) {
        return new Response(data);
    }

    public static Response ok() {
        return new Response(null);
    }


    public Response() {
    }


    public Response(Object data) {
        this.status = ResponseCode.OPERATION_SUCCESS.getStatus();
        this.msg = ResponseCode.OPERATION_SUCCESS.getMsg();
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
