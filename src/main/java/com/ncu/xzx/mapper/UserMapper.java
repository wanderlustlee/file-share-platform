package com.ncu.xzx.mapper;


import com.ncu.xzx.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectByUserNameAndPassword(String userName, String password);

    int insert(User user);

    User getUserById(int id);
}
