package com.ncu.xzx.service;

import com.ncu.xzx.mapper.ShortAnswerQuestionMapper;
import com.ncu.xzx.mapper.UserMapper;
import com.ncu.xzx.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShortAnswerQuestionServiceImpl implements ShortAnswerQuestionService{

    @Autowired
    ShortAnswerQuestionMapper shortAnswerQuestionMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public int addShortAnswerQuestion(ShortAnswerQuestion shortAnswerQuestion) {
        return shortAnswerQuestionMapper.addShortAnswerQuestion(shortAnswerQuestion);
    }

    @Override
    public List<ShortAnswerQuestion> getShortAnswerQuestionByPage(int offset, int pageSize) {
        return shortAnswerQuestionMapper.getShortAnswerQuestionByPage(offset, pageSize);
    }

    @Override
    public List<ShortAnswerQuestion> getByUserId(int userId) {
        return shortAnswerQuestionMapper.getByUserId(userId);
    }

    @Override
    public int countAllShortAnswerQuestions() {
        return shortAnswerQuestionMapper.countAllShortAnswerQuestions();
    }

    @Override
    public List<ShortAnswerQuestionVo> shortAnswerQuestionToShortAnswerQuestionVo(List<ShortAnswerQuestion> shortAnswerQuestionList) {
        List<ShortAnswerQuestionVo> shortAnswerQuestionVoList = new ArrayList<>();
        shortAnswerQuestionList.forEach(shortAnswerQuestion -> {
            ShortAnswerQuestionVo shortAnswerQuestionVo = new ShortAnswerQuestionVo();
            BeanUtils.copyProperties(shortAnswerQuestion, shortAnswerQuestionVo);
            // 转换时间为字符串
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = format.format(shortAnswerQuestion.getCreateTime());
            shortAnswerQuestionVo.setCreateTime(createTime);
            User user = userMapper.getUserById(shortAnswerQuestion.getUserId());
            if (user != null) {
                shortAnswerQuestionVo.setUserName(user.getUserName());
            }
            shortAnswerQuestionVoList.add(shortAnswerQuestionVo);
        });
        return shortAnswerQuestionVoList;
    }

    @Override
    public int updateShortAnswerQuestion(ShortAnswerQuestion shortAnswerQuestion) {
        return shortAnswerQuestionMapper.updateShortAnswerQuestion(shortAnswerQuestion);
    }

    @Override
    public List<ChoiceQuestion> getByDescription(String description) {
        return shortAnswerQuestionMapper.getByDescription(description);
    }
}
