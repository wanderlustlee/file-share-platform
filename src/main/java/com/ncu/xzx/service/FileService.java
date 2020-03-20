package com.ncu.xzx.service;

import com.ncu.xzx.model.FileVo;

import java.util.List;

public interface FileService {
    int upload(FileVo file);
    int download(FileVo file);
    List<FileVo> getFileList();
}
