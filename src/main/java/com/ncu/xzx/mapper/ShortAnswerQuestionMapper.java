package com.ncu.xzx.mapper;

import com.ncu.xzx.model.ChoiceQuestion;
import com.ncu.xzx.model.ShortAnswerQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShortAnswerQuestionMapper {

    int addShortAnswerQuestion(ShortAnswerQuestion shortAnswerQuestion);

    List<ShortAnswerQuestion> getShortAnswerQuestionByPage(int offset, int pageSize);

    List<ShortAnswerQuestion> getByUserId(int userId);

    int countAllShortAnswerQuestions();

    int updateShortAnswerQuestion(ShortAnswerQuestion shortAnswerQuestion);

    List<ShortAnswerQuestion> getByDescription(String description);

    ShortAnswerQuestion getById(int id);

    ShortAnswerQuestion getMaxId();
}
