package com.ncu.xzx.controller;

import com.ncu.xzx.model.Paper;
import com.ncu.xzx.model.PaperDto;
import com.ncu.xzx.model.PaperVo;
import com.ncu.xzx.service.PaperService;
import com.ncu.xzx.utils.Response;
import com.ncu.xzx.utils.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    PaperService paperService;

    @GetMapping("/question/list")
    @UserLoginToken
    public Response getPagerList(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize") int pageSize) {
        int offset = (pageIndex - 1) * pageSize;
        List<Paper> paperList = paperService.getPaperQuestionsByPage(offset, pageSize);
        List<PaperVo> paperVoList = paperService.paperToPaperVo(paperList);
        int count = paperService.countAllPaperQuestions();
        PaperDto paperDto = new PaperDto();
        paperDto.setPaperVoList(paperVoList);
        paperDto.setCount(count);
        return Response.ok(paperDto);
    }
}
