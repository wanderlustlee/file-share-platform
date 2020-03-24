package com.ncu.xzx.service;


import com.ncu.xzx.model.ChoiceQuestion;
import com.ncu.xzx.model.ShortAnswerQuestion;

import java.util.List;

public interface ShortAnswerQuestionService {
    int addShortAnswerQuestion(ShortAnswerQuestion shortAnswerQuestion);

    List<ShortAnswerQuestion> getShortAnswerQuestionByPage(int offset, int pageSize);

    List<ShortAnswerQuestion> getByUserId(int userId);

    int countAllShortAnswerQuestions();
}
