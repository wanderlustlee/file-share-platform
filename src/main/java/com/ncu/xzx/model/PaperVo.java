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
public class PaperVo {
    private int id;
    private int userId;
    private String userName;
    private String paperName;
    private String paperPath;
    private String createTime;
}
