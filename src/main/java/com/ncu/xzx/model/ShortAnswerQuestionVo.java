package com.ncu.xzx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortAnswerQuestionVo {
    private int id;
    private int userId;
    private String userName;
    private String description;
    private int point;
    private String createTime;
    private int isDelete;

}
