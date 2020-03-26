package com.ncu.xzx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceQuestionDto {
    private List<ChoiceQuestionVo> choiceQuestionVoList;
    private int count;
}
