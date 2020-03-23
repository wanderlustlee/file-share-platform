package com.ncu.xzx.service;

import com.ncu.xzx.mapper.FileMapper;
import com.ncu.xzx.mapper.UserMapper;
import com.ncu.xzx.model.FileDto;
import com.ncu.xzx.model.FileVo;
import com.ncu.xzx.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    FileMapper fileMapper;
    @Autowired
    UserMapper userMapper;


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

    @Override
    public List<FileVo> getByFileName(String fileName) {
        return fileMapper.getByFileName(fileName);
    }

    @Override
    public List<FileVo> getByUserId(int userId) {
        return fileMapper.getByUserId(userId);
    }

    @Override
    public List<FileDto> FileVoToFileDto(List<FileVo> fileVoList) {
        List<FileDto> fileDtoList = new ArrayList<>();
        fileVoList.forEach(fileVo -> {
            FileDto fileDto = new FileDto();
            BeanUtils.copyProperties(fileVo, fileDto);
            // 转换时间为字符串
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = format.format(fileVo.getCreateTime());
            fileDto.setCreateTime(createTime);
            User user = userMapper.getUserById(fileVo.getUserId());
            if (user != null) {
                fileDto.setUserName(user.getUserName());
            }
            fileDtoList.add(fileDto);
        });
        return fileDtoList;
    }
}
