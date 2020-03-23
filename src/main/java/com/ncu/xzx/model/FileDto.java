package com.ncu.xzx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileDto {
    private int id;
    private int userId;
    private String userName;
    private String operateType;
    private String fileName;
    private String filePath;
    private String createTime;
}
