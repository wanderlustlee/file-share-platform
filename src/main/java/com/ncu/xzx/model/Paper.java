package com.ncu.xzx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Paper {
    private int id;
    private int userId;
    private String paperName;
    private String paperPath;
    private Timestamp createTime;
    private Timestamp updateTime;
}
