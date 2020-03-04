package com.ncu.xzx.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
