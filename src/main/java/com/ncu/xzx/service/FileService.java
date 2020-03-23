package com.ncu.xzx.service;

import com.ncu.xzx.model.FileDto;
import com.ncu.xzx.model.FileVo;

import java.util.List;

public interface FileService {
    int upload(FileVo file);

    int download(FileVo file);

    List<FileVo> getFileList();

    List<FileVo> getByFileName(String fileName);

    List<FileVo> getByUserId(int userId);

    List<FileDto> FileVoToFileDto(List<FileVo> fileVoList);
}
