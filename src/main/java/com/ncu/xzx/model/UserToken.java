package com.ncu.xzx.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class UserToken {
    private int id;
    private int userId;
    private String token;
    private Timestamp createTime;
    private Timestamp updateTime;
}
