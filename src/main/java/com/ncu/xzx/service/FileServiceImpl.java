package com.ncu.xzx.service;

import com.ncu.xzx.mapper.FileMapper;
import com.ncu.xzx.model.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    FileMapper fileMapper;
    @Override
    public int upload(FileVo file) {
        return fileMapper.addFile(file);
    }
}
