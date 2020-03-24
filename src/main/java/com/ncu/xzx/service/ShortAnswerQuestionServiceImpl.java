package com.ncu.xzx.service;

import com.ncu.xzx.mapper.ShoreAnswerQuestionMapper;
import com.ncu.xzx.model.ShortAnswerQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortAnswerQuestionServiceImpl implements ShortAnswerQuestionService{

    @Autowired
    ShoreAnswerQuestionMapper shoreAnswerQuestionMapper;

    @Override
    public int addShortAnswerQuestion(ShortAnswerQuestion shortAnswerQuestion) {
        return shoreAnswerQuestionMapper.addShortAnswerQuestion(shortAnswerQuestion);
    }

    @Override
    public List<ShortAnswerQuestion> getShortAnswerQuestionByPage(int offset, int pageSize) {
        return shoreAnswerQuestionMapper.getShortAnswerQuestionByPage(offset, pageSize);
    }

    @Override
    public List<ShortAnswerQuestion> getByUserId(int userId) {
        return shoreAnswerQuestionMapper.getByUserId(userId);
    }

    @Override
    public int countAllShortAnswerQuestions() {
        return shoreAnswerQuestionMapper.countAllShortAnswerQuestions();
    }
}
