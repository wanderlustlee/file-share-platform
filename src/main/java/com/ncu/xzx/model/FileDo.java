package com.ncu.xzx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDo {
    private int id;
    private int userId;
    private String operateType;
    private String fileName;
    private String filePath;
    private Timestamp createTime;
    private Timestamp updateTime;
}
