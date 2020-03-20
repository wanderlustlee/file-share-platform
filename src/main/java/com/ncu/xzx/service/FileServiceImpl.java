package com.ncu.xzx.service;

import com.ncu.xzx.mapper.FileMapper;
import com.ncu.xzx.model.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    FileMapper fileMapper;

    @Override
    public int upload(FileVo file) {
        return fileMapper.uploadFile(file);
    }

    @Override
    public int download(FileVo file) {
        return fileMapper.downloadFile(file);
    }

    @Override
    public List<FileVo> getFileList() {
        return fileMapper.getAllFiles();
    }
}
