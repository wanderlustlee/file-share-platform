package com.ncu.xzx.mapper;

import com.ncu.xzx.model.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperAnswerMapper {

    List<Paper> getPaperAnswersByPage(int offset, int pageSize);

    List<Paper> getByUserId(int userId);

    int countAllPaperAnswers();

    int addPaperAnswer(Paper paperAnswer);
}
