package com.ncu.xzx.mapper;

import com.ncu.xzx.model.FileVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

    int uploadFile(FileVo file);

    int downloadFile(FileVo file);

    List<FileVo> getAllFiles();
}
