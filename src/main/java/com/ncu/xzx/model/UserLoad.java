package com.ncu.xzx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoad {
    private int id;
    private int userId;
    private int uploadTimes;
    private int downloadTimes;
    private Timestamp createTime;
    private Timestamp updateTime;
}
