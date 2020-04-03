package com.ncu.xzx.service;

import com.ncu.xzx.mapper.ChoiceQuestionMapper;
import com.ncu.xzx.mapper.UserMapper;
import com.ncu.xzx.model.ChoiceQuestion;
import com.ncu.xzx.model.ChoiceQuestionVo;
import com.ncu.xzx.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService{

    @Autowired
    ChoiceQuestionMapper choiceQuestionMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public int addChoiceQuestion(ChoiceQuestion choiceQuestion) {
        return choiceQuestionMapper.addChoiceQuestion(choiceQuestion);
    }

    @Override
    public List<ChoiceQuestion> getChoiceQuestionByPage(int offset, int pageSize) {
        return choiceQuestionMapper.getChoiceQuestionByPage(offset, pageSize);
    }

    @Override
    public List<ChoiceQuestion> getByUserId(int userId) {
        return choiceQuestionMapper.getByUserId(userId);
    }

    @Override
    public int countAllChoiceQuestions() {
        return choiceQuestionMapper.countAllChoiceQuestions();
    }

    @Override
    public List<ChoiceQuestionVo> choiceQuestionToChoiceQuestionVo(List<ChoiceQuestion> choiceQuestionList) {
        List<ChoiceQuestionVo> choiceQuestionVoList = new ArrayList<>();
        choiceQuestionList.forEach(choiceQuestion -> {
            ChoiceQuestionVo choiceQuestionVo = new ChoiceQuestionVo();
            BeanUtils.copyProperties(choiceQuestion, choiceQuestionVo);
            // 转换时间为字符串
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = format.format(choiceQuestion.getCreateTime());
            choiceQuestionVo.setCreateTime(createTime);
            User user = userMapper.getUserById(choiceQuestion.getUserId());
            if (user != null) {
                choiceQuestionVo.setUserName(user.getUserName());
            }
            choiceQuestionVoList.add(choiceQuestionVo);
        });
        return choiceQuestionVoList;
    }

    @Override
    public int updateChoiceQuestion(ChoiceQuestion choiceQuestion) {
        return choiceQuestionMapper.updateChoiceQuestion(choiceQuestion);
    }

    @Override
    public List<ChoiceQuestion> getByDescription(String description) {
        return choiceQuestionMapper.getByDescription(description);
    }

    @Override
    public ChoiceQuestion getById(int id) {
        return choiceQuestionMapper.getById(id);
    }

    @Override
    public ChoiceQuestion getMaxId() {
        return choiceQuestionMapper.getMaxId();
    }
}
