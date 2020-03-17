package com.ncu.xzx.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserToken {
    private int id;
    private int userId;
    private String token;
    private Date createTime;
    private Date updateTime;
}
