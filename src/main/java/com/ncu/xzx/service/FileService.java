package com.ncu.xzx.service;

import com.ncu.xzx.model.FileVo;

public interface FileService {
    int upload(FileVo file);
    int download(FileVo file);
}
