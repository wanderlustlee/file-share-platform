package com.ncu.xzx.service;

import com.ncu.xzx.model.FileVo;
import com.ncu.xzx.model.FileDo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    int upload(MultipartFile file, int userId);

    int download(FileDo file);

    List<FileDo> getFileList(int offset, int pageSize);

    List<FileDo> getByFileName(String fileName);

    List<FileDo> getByUserId(int userId);

    List<FileVo> FileDoToFileVo(List<FileDo> fileDoList);

    int countAllFiles();
}
