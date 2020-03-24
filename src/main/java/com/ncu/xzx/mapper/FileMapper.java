package com.ncu.xzx.mapper;

import com.ncu.xzx.model.FileDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

    int uploadFile(FileDo file);

    int downloadFile(FileDo file);

    List<FileDo> getFilesByPage(int offset, int pageSize);

    List<FileDo> getByFileName(String fileName);

    List<FileDo> getByUserId(int userId);

    int countAllFiles();
}
