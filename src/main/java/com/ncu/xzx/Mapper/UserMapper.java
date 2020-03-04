package com.ncu.xzx.Mapper;


import com.ncu.xzx.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int login(String userName, String password);
    int register(User user);
}
