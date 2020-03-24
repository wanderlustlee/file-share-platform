package com.ncu.xzx.service;

import com.ncu.xzx.model.FileVo;
import com.ncu.xzx.model.FileDo;

import java.util.List;

public interface FileService {
    int upload(FileDo file);

    int download(FileDo file);

    List<FileDo> getFileList(int offset, int pageSize);

    List<FileDo> getByFileName(String fileName);

    List<FileDo> getByUserId(int userId);

    List<FileVo> FileVoToFileDto(List<FileDo> fileDoList);

    int countAllFiles();
}
