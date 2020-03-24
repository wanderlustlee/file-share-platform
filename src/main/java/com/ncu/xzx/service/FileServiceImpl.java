package com.ncu.xzx.service;

import com.ncu.xzx.mapper.FileMapper;
import com.ncu.xzx.mapper.UserMapper;
import com.ncu.xzx.model.FileVo;
import com.ncu.xzx.model.FileDo;
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
    public int upload(FileDo file) {
        return fileMapper.uploadFile(file);
    }

    @Override
    public int download(FileDo file) {
        return fileMapper.downloadFile(file);
    }

    @Override
    public List<FileDo> getFileList(int offset, int pageSize) {
        return fileMapper.getFilesByPage(offset, pageSize);
    }

    @Override
    public List<FileDo> getByFileName(String fileName) {
        return fileMapper.getByFileName(fileName);
    }

    @Override
    public List<FileDo> getByUserId(int userId) {
        return fileMapper.getByUserId(userId);
    }

    @Override
    public List<FileVo> FileVoToFileDto(List<FileDo> fileDoList) {
        List<FileVo> fileVoList = new ArrayList<>();
        fileDoList.forEach(fileVo -> {
            FileVo fileDto = new FileVo();
            BeanUtils.copyProperties(fileVo, fileDto);
            // 转换时间为字符串
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = format.format(fileVo.getCreateTime());
            fileDto.setCreateTime(createTime);
            User user = userMapper.getUserById(fileVo.getUserId());
            if (user != null) {
                fileDto.setUserName(user.getUserName());
            }
            fileVoList.add(fileDto);
        });
        return fileVoList;
    }

    @Override
    public int countAllFiles() {
        return fileMapper.countAllFiles();
    }
}
