package com.ncu.xzx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileVo {
    private int id;
    private int userId;
    private String fileName;
    private String filePath;
    private Date createTime;
    private Date updateTime;
}
