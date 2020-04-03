package com.ncu.xzx.service;


import com.ncu.xzx.model.ChoiceQuestion;
import com.ncu.xzx.model.ChoiceQuestionVo;
import com.ncu.xzx.model.FileDo;
import com.ncu.xzx.model.FileVo;

import java.util.List;

public interface ChoiceQuestionService {
    int addChoiceQuestion(ChoiceQuestion choiceQuestion);

    List<ChoiceQuestion> getChoiceQuestionByPage(int offset, int pageSize);

    List<ChoiceQuestion> getByUserId(int userId);

    int countAllChoiceQuestions();

    List<ChoiceQuestionVo> choiceQuestionToChoiceQuestionVo(List<ChoiceQuestion> choiceQuestionList);

    int updateChoiceQuestion(ChoiceQuestion choiceQuestion);

    List<ChoiceQuestion> getByDescription(String description);

    ChoiceQuestion getById(int id);

    ChoiceQuestion getMaxId();

}
