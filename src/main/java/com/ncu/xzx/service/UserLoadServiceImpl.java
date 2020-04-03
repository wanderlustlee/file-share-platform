package com.ncu.xzx.service;

import com.ncu.xzx.mapper.UserLoadMapper;
import com.ncu.xzx.model.UserLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserLoadServiceImpl implements UserLoadService{

    @Autowired
    UserLoadMapper userLoadMapper;

    @Override
    public int insertOrUpdateUserLoad(int userId, String type) {
        UserLoad userLoad = userLoadMapper.getByUserId(userId);
        if (userLoad == null) {
            UserLoad newUserLoad = new UserLoad();
            newUserLoad.setUserId(userId);
            userLoadMapper.addUserLoad(newUserLoad);
        }
        if ("upload".equals(type)) {
            userLoadMapper.updateUploadTimes(userId);
        }else {
            userLoadMapper.updateDownloadTimes(userId);
        }
        return 0;
    }

    @Override
    public UserLoad getByUserId(int userId) {
        return userLoadMapper.getByUserId(userId);
    }
}
