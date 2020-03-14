package com.ncu.xzx.model;

import lombok.Data;

@Data
public class UserToken {
    private int id;
    private int userId;
    private String token;
}
