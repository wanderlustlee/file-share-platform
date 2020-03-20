package com.ncu.xzx.model;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private String name;
    private List<String> roles;
    private String introduce;
}
