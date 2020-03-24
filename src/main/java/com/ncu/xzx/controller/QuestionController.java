package com.ncu.xzx.controller;

import com.ncu.xzx.model.ChoiceQuestion;
import com.ncu.xzx.model.ChoiceQuestionVo;
import com.ncu.xzx.service.ChoiceQuestionService;
import com.ncu.xzx.service.ShortAnswerQuestionService;
import com.ncu.xzx.utils.Response;
import com.ncu.xzx.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/question")
@RestController
public class QuestionController {

    @Autowired
    ChoiceQuestionService choiceQuestionService;

    @Autowired
    ShortAnswerQuestionService shortAnswerQuestionService;

    @GetMapping("/all-choice-questions")
    @UserLoginToken
    public Response getAllChoiceQuestions(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize){
        int offset = (pageIndex - 1) * pageSize;
        List<ChoiceQuestion> choiceQuestionList = choiceQuestionService.getChoiceQuestionByPage(offset, pageSize);
        List<ChoiceQuestionVo> choiceQuestionVoList = choiceQuestionService.choiceQuestionToChoiceQuestionVo(choiceQuestionList);
        return new Response(choiceQuestionVoList);
    }
}
