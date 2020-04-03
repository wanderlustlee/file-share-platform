package com.ncu.xzx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ncu.xzx.model.*;
import com.ncu.xzx.service.ChoiceQuestionService;
import com.ncu.xzx.service.PaperService;
import com.ncu.xzx.service.ShortAnswerQuestionService;
import com.ncu.xzx.service.UserTokenService;
import com.ncu.xzx.utils.Response;
import com.ncu.xzx.utils.ResponseCode;
import com.ncu.xzx.utils.UserLoginToken;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RequestMapping("/question")
@RestController
public class QuestionController {

    @Autowired
    ChoiceQuestionService choiceQuestionService;

    @Autowired
    ShortAnswerQuestionService shortAnswerQuestionService;

    @Autowired
    UserTokenService userTokenService;

    @Autowired
    PaperService paperService;

    @GetMapping("/choice/list")
    @UserLoginToken
    public Response getAllChoiceQuestions(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize){
        int offset = (pageIndex - 1) * pageSize;
        List<ChoiceQuestion> choiceQuestionList = choiceQuestionService.getChoiceQuestionByPage(offset, pageSize);
        List<ChoiceQuestionVo> choiceQuestionVoList = choiceQuestionService.choiceQuestionToChoiceQuestionVo(choiceQuestionList);
        int count = choiceQuestionService.countAllChoiceQuestions();
        ChoiceQuestionDto choiceQuestionDto = new ChoiceQuestionDto(choiceQuestionVoList, count);
        return Response.ok(choiceQuestionDto);
    }

    @PostMapping("/choice/add")
    @UserLoginToken
    public Response addChoiceQuestion(@RequestParam("choiceQuestionData") String choiceQuestionString, HttpServletRequest request){
        if (choiceQuestionString == null) {
            return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "参数为空");
        }
        String token = request.getHeader("Authorization");
        UserToken userToken = userTokenService.getByToken(token);
        int userId = userToken.getUserId();
        ChoiceQuestion choiceQuestion = JSONObject.parseObject(choiceQuestionString, ChoiceQuestion.class);
        choiceQuestion.setUserId(userId);
        int result = choiceQuestionService.addChoiceQuestion(choiceQuestion);
        if (result > 0) {
            return Response.ok();
        }
        return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "添加失败");
    }


    @PostMapping("/choice/update")
    @UserLoginToken
    public Response updateChoiceQuestion(@RequestParam("choiceQuestionData") String choiceQuestionString, HttpServletRequest request){
        if (choiceQuestionString == null) {
            return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "参数为空");
        }
        ChoiceQuestion choiceQuestion = JSONObject.parseObject(choiceQuestionString, ChoiceQuestion.class);
        int result = choiceQuestionService.updateChoiceQuestion(choiceQuestion);
        if (result > 0) {
            return Response.ok();
        }
        return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "修改失败");
    }

    @GetMapping("/choice/query")
    @UserLoginToken
    public Response queryChoiceQuestion(@RequestParam("description") String description){
        List<ChoiceQuestion> choiceQuestionList = choiceQuestionService.getByDescription(description);
        List<ChoiceQuestionVo> choiceQuestionVoList = choiceQuestionService.choiceQuestionToChoiceQuestionVo(choiceQuestionList);
        ChoiceQuestionDto choiceQuestionDto = new ChoiceQuestionDto(choiceQuestionVoList, choiceQuestionVoList.size());
        return Response.ok(choiceQuestionDto);
    }


    @GetMapping("/short-answer/list")
    @UserLoginToken
    public Response getAllShortAnswerQuestions(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize){
        int offset = (pageIndex - 1) * pageSize;
        List<ShortAnswerQuestion> shortAnswerQuestionList = shortAnswerQuestionService.getShortAnswerQuestionByPage(offset, pageSize);
        List<ShortAnswerQuestionVo> shortAnswerQuestionVoList = shortAnswerQuestionService.shortAnswerQuestionToShortAnswerQuestionVo(shortAnswerQuestionList);
        int count = shortAnswerQuestionService.countAllShortAnswerQuestions();
        ShortAnswerQuestionDto shortAnswerQuestionDto = new ShortAnswerQuestionDto(shortAnswerQuestionVoList, count);
        return new Response(shortAnswerQuestionDto);
    }

    @PostMapping("/short-answer/add")
    @UserLoginToken
    public Response addShortAnswerQuestion(@RequestParam("shortAnswerQuestionData") String shortAnswerQuestionString, HttpServletRequest request){
        if (shortAnswerQuestionString == null) {
            return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "参数为空");
        }
        String token = request.getHeader("Authorization");
        UserToken userToken = userTokenService.getByToken(token);
        int userId = userToken.getUserId();
        ShortAnswerQuestion shortAnswerQuestion = JSONObject.parseObject(shortAnswerQuestionString, ShortAnswerQuestion.class);
        shortAnswerQuestion.setUserId(userId);
        int result = shortAnswerQuestionService.addShortAnswerQuestion(shortAnswerQuestion);
        if (result > 0) {
            return Response.ok();
        }
        return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "添加失败");
    }


    @PostMapping("/short-answer/update")
    @UserLoginToken
    public Response updateShortAnswerQuestion(@RequestParam("shortAnswerQuestionData") String shortAnswerQuestionString, HttpServletRequest request){
        if (shortAnswerQuestionString == null) {
            return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "参数为空");
        }
        ShortAnswerQuestion shortAnswerQuestion = JSONObject.parseObject(shortAnswerQuestionString, ShortAnswerQuestion.class);
        int result = shortAnswerQuestionService.updateShortAnswerQuestion(shortAnswerQuestion);
        if (result > 0) {
            return Response.ok();
        }
        return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "修改失败");
    }

    @GetMapping("/short-answer/query")
    @UserLoginToken
    public Response queryShortAnswerQuestion(@RequestParam("description") String description){
        List<ShortAnswerQuestion> shortAnswerQuestionList = shortAnswerQuestionService.getByDescription(description);
        List<ShortAnswerQuestionVo> shortAnswerQuestionVoList = shortAnswerQuestionService.shortAnswerQuestionToShortAnswerQuestionVo(shortAnswerQuestionList);
        ShortAnswerQuestionDto shortAnswerQuestionDto = new ShortAnswerQuestionDto(shortAnswerQuestionVoList, shortAnswerQuestionList.size());
        return Response.ok(shortAnswerQuestionDto);
    }

    @GetMapping("/generate-paper")
    @UserLoginToken
    public Response generateQuestionPaper(@RequestParam("choiceQuestionNumber") Integer choiceQuestionNumber, @RequestParam("shortAnswerQuestionNumber") Integer shortAnswerQuestionNumber, HttpServletRequest request){
        if (choiceQuestionNumber == null || shortAnswerQuestionNumber == null) {
            return new Response(ResponseCode.OPERATION_ERROR.getStatus(), ResponseCode.OPERATION_ERROR.getMsg(), "参数为空");
        }
        String token = request.getHeader("Authorization");
        UserToken userToken = userTokenService.getByToken(token);
        int userId = userToken.getUserId();
        boolean result = paperService.generateQuestionPaper(userId, choiceQuestionNumber, shortAnswerQuestionNumber);
        if (!result) {
            return Response.failed("试卷生成失败");
        }
        return Response.ok();
    }
}
