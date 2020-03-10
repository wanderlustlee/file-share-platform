package com.ncu.xzx.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class User {
    private int id;
    private String userName;
    private String nickName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
