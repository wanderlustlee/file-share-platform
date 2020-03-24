package com.ncu.xzx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChoiceQuestion {
    private int id;
    private int userId;
    private String description;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private int point;
    private Date createTime;
    private Date updateTime;
    private int isDelete;

}
