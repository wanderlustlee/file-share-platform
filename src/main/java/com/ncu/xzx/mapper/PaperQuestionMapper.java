package com.ncu.xzx.mapper;

import com.ncu.xzx.model.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperQuestionMapper {

    List<Paper> getPaperQuestionsByPage(int offset, int pageSize);

    List<Paper> getByUserId(int userId);

    int countAllPaperQuestions();

    int addPaperQuestion(Paper paperQuestion);
}
