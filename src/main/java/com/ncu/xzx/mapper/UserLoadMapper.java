package com.ncu.xzx.mapper;

import com.ncu.xzx.model.UserLoad;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoadMapper {
    UserLoad getByUserId(int userId);
    int addUserLoad(UserLoad userLoad);
    int updateUploadTimes(int userId);
    int updateDownloadTimes(int userId);
}
