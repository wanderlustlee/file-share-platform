package com.ncu.xzx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortAnswerQuestion {
    private int id;
    private int userId;
    private String description;
    private int point;
    private Date createTime;
    private Date updateTime;
    private int isDelete;

}
