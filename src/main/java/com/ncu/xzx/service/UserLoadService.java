package com.ncu.xzx.service;

import com.ncu.xzx.model.UserLoad;

import java.util.List;

public interface UserLoadService {
    int insertOrUpdateUserLoad(int userId, String type);
    UserLoad getByUserId(int userId);
}
