package com.ncu.xzx.mapper;


import com.ncu.xzx.model.User;
import com.ncu.xzx.model.UserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTokenMapper {
    UserToken getByToken(String token);

    int addUserToken(int userId, String token);
}
