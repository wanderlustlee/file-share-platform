package com.ncu.xzx.mapper;

import com.ncu.xzx.model.FileVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    int addFile(FileVo file);
}
