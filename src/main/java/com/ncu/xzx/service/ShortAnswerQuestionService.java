package com.ncu.xzx.service;


import com.ncu.xzx.model.ChoiceQuestion;
import com.ncu.xzx.model.ChoiceQuestionVo;
import com.ncu.xzx.model.ShortAnswerQuestion;
import com.ncu.xzx.model.ShortAnswerQuestionVo;

import java.util.List;

public interface ShortAnswerQuestionService {
    int addShortAnswerQuestion(ShortAnswerQuestion shortAnswerQuestion);

    List<ShortAnswerQuestion> getShortAnswerQuestionByPage(int offset, int pageSize);

    List<ShortAnswerQuestion> getByUserId(int userId);

    int countAllShortAnswerQuestions();

    List<ShortAnswerQuestionVo> shortAnswerQuestionToShortAnswerQuestionVo(List<ShortAnswerQuestion> shortAnswerQuestionList);

    int updateShortAnswerQuestion(ShortAnswerQuestion shortAnswerQuestion);

    List<ShortAnswerQuestion> getByDescription(String description);

    ShortAnswerQuestion getById(int id);
}
