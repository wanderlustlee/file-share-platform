package com.ncu.xzx.service;

import com.ncu.xzx.model.Paper;
import com.ncu.xzx.model.PaperVo;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface PaperService {
    int addPaperQuestion(Paper paperQuestion);

    int addPaperAnswer(Paper paperAnswer);

    List<Paper> getPaperQuestionsByPage(int offset, int pageSize);

    List<Paper> getPaperAnswersByPage(int offset, int pageSize);

    List<Paper> getPaperQuestionByUserId(int userId);

    List<Paper> getPaperAnswerByUserId(int userId);

    int countAllPaperQuestions();

    int countAllPaperAnswers();

    boolean generateQuestionPaper(int userId, int choiceQuestionNumber, int shortAnswerQuestionNumber);

    List<PaperVo> paperToPaperVo(List<Paper> paperList);



}
