package com.ncu.xzx.service;

import com.ncu.xzx.mapper.PaperAnswerMapper;
import com.ncu.xzx.mapper.PaperQuestionMapper;
import com.ncu.xzx.mapper.UserMapper;
import com.ncu.xzx.model.*;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperQuestionMapper paperQuestionMapper;

    @Autowired
    PaperAnswerMapper paperAnswerMapper;

    @Autowired
    ChoiceQuestionService choiceQuestionService;

    @Autowired
    ShortAnswerQuestionService shortAnswerQuestionService;

    @Autowired
    UserMapper userMapper;


    public static String PATH = "/Users/vivo/paper";

    @Override
    public int addPaperQuestion(Paper paperQuestion) {
        return paperQuestionMapper.addPaperQuestion(paperQuestion);
    }

    @Override
    public int addPaperAnswer(Paper paperAnswer) {
        return paperAnswerMapper.addPaperAnswer(paperAnswer);
    }

    @Override
    public List<Paper> getPaperQuestionsByPage(int offset, int pageSize) {
        return paperQuestionMapper.getPaperQuestionsByPage(offset, pageSize);
    }

    @Override
    public List<Paper> getPaperAnswersByPage(int offset, int pageSize) {
        return paperAnswerMapper.getPaperAnswersByPage(offset, pageSize);
    }

    @Override
    public List<Paper> getPaperQuestionByUserId(int userId) {
        return paperQuestionMapper.getByUserId(userId);
    }

    @Override
    public List<Paper> getPaperAnswerByUserId(int userId) {
        return paperAnswerMapper.getByUserId(userId);
    }

    @Override
    public int countAllPaperQuestions() {
        return paperQuestionMapper.countAllPaperQuestions();
    }

    @Override
    public int countAllPaperAnswers() {
        return paperAnswerMapper.countAllPaperAnswers();
    }

    @Override
    public boolean generateQuestionPaper(int userId, int choiceQuestionNumber, int shortAnswerQuestionNumber) {
        int choiceQuestionMaxId = choiceQuestionService.getMaxId().getId();
        int shortAnswerQuestionMaxId = shortAnswerQuestionService.getMaxId().getId();
        Set<Integer> randomChoiceQuestionIdSet = new HashSet<>(choiceQuestionNumber);
        Set<Integer> randomShortAnswerQuestionIdSet = new HashSet<>(shortAnswerQuestionNumber);

        List<ChoiceQuestion> choiceQuestionList = new ArrayList<>(choiceQuestionNumber);
        List<ShortAnswerQuestion> shortAnswerQuestionList = new ArrayList<>(shortAnswerQuestionNumber);

        Random random = new Random();

        // 从1到maxId生成随机数，获取试题，如果获取到才++
        for (int i = 0; i < choiceQuestionNumber;) {
            int randomNumber = random.nextInt(choiceQuestionMaxId + 1);
            // 添加到set，用于去重
            while (!randomChoiceQuestionIdSet.add(randomNumber)) {
                randomNumber = random.nextInt(choiceQuestionMaxId + 1);
            }

            ChoiceQuestion choiceQuestion = choiceQuestionService.getById(randomNumber);
            // 如果能获取到对应试题，才++
            if (choiceQuestion != null) {
                ++i;
                choiceQuestionList.add(choiceQuestion);
            }
        }

        for (int j = 0; j < shortAnswerQuestionNumber;) {
            int randomNumber = random.nextInt(shortAnswerQuestionMaxId + 1);
            // 添加到set，用于去重
            while (!randomShortAnswerQuestionIdSet.add(randomNumber)) {
                randomNumber = random.nextInt(shortAnswerQuestionMaxId + 1);
            }

            ShortAnswerQuestion shortAnswerQuestion = shortAnswerQuestionService.getById(randomNumber);
            // 如果能获取到对应试题，才++
            if (shortAnswerQuestion != null) {
                ++j;
                shortAnswerQuestionList.add(shortAnswerQuestion);
            }
        }


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String createTime = format.format(new Date());

        final String questionName = "试题-" + createTime;
        final String answerName = "答案-" + createTime;

        final String questionPath = PATH + File.separator + questionName + ".doc";
        final String answerPath = PATH + File.separator + answerName + ".doc";

        try {
            XWPFDocument questionDoc = new XWPFDocument();// 创建Word文件
            XWPFDocument answerDoc = new XWPFDocument();// 创建Word文件


            // 1. 创建段落
            XWPFParagraph paragraph = questionDoc.createParagraph();// 新建一个段落
            paragraph.setAlignment(ParagraphAlignment.CENTER);// 设置段落的对齐方式
            // 1.1 标题
            XWPFRun title = paragraph.createRun();//创建段落文本
            title.setText("试题");
            title.setBold(true);//设置为粗体
            // 1.2 正文段落
            paragraph = questionDoc.createParagraph();// 新建一个段落
            title = paragraph.createRun();
            title.setText("一、选择题");

            // 1. 创建段落
            XWPFParagraph answerParagraph = answerDoc.createParagraph();// 新建一个段落
            answerParagraph.setAlignment(ParagraphAlignment.CENTER);// 设置段落的对齐方式
            // 1.1 标题
            XWPFRun answerTitle = answerParagraph.createRun();//创建段落文本
            answerTitle.setText("答案");
            answerTitle.setBold(true);//设置为粗体
            // 1.2 正文段落
            answerParagraph = answerDoc.createParagraph();// 新建一个段落
            answerTitle = answerParagraph.createRun();
            answerTitle.setText("一、选择题");

            for (int i = 0; i < choiceQuestionList.size(); i++) {
                XWPFParagraph localParagraph = questionDoc.createParagraph();// 新建一个段落
                XWPFRun localTitle = localParagraph.createRun();
                localTitle.setText((i + 1) + "、" + choiceQuestionList.get(i).getDescription());

                localParagraph = questionDoc.createParagraph();// 新建一个段落
                localTitle = localParagraph.createRun();
                localTitle.setText("(" + choiceQuestionList.get(i).getPoint() + "分)");

                localParagraph = questionDoc.createParagraph();// 新建一个段落
                localTitle = localParagraph.createRun();
                localTitle.setText("A、" + choiceQuestionList.get(i).getOptionA());

                localParagraph = questionDoc.createParagraph();// 新建一个段落
                localTitle = localParagraph.createRun();
                localTitle.setText("B、" + choiceQuestionList.get(i).getOptionB());

                localParagraph = questionDoc.createParagraph();// 新建一个段落
                localTitle = localParagraph.createRun();
                localTitle.setText("C、" + choiceQuestionList.get(i).getOptionC());

                localParagraph = questionDoc.createParagraph();// 新建一个段落
                localTitle = localParagraph.createRun();
                localTitle.setText("D、" + choiceQuestionList.get(i).getOptionD());

                localTitle.setText(" ");

                XWPFParagraph answerLocalParagraph = answerDoc.createParagraph();// 新建一个段落
                XWPFRun answerLocalTitle = answerLocalParagraph.createRun();
                answerLocalTitle.setText((i + 1) + "、" + choiceQuestionList.get(i).getAnswer());

            }
            answerTitle.addBreak();

            // 1.3 正文段落
            paragraph = questionDoc.createParagraph();// 新建一个段落
            title = paragraph.createRun();
            title.setText("二、简答题");

            for (int j = 0; j < shortAnswerQuestionList.size(); j++) {
                XWPFParagraph localParagraph = questionDoc.createParagraph();// 新建一个段落
                XWPFRun localTitle = localParagraph.createRun();
                localTitle.setText((j + 1) + "、" + shortAnswerQuestionList.get(j).getDescription());

                localParagraph = questionDoc.createParagraph();// 新建一个段落
                localTitle = localParagraph.createRun();

                localTitle.addBreak();
                localTitle.addBreak();
                localTitle.addBreak();
                localTitle.addBreak();
                localTitle.addBreak();
                localTitle.addBreak();
                localTitle.addBreak();
                localTitle.addBreak();
                localTitle.addBreak();
                localTitle.addBreak();
            }

            FileOutputStream questionOut = new FileOutputStream(questionPath);
            questionDoc.write(questionOut);
            questionOut.close();

            FileOutputStream answerOut = new FileOutputStream(answerPath);
            answerDoc.write(answerOut);
            answerOut.close();

            Paper paperQuestion = new Paper();
            paperQuestion.setUserId(userId);
            paperQuestion.setPaperName(questionName + ".doc");
            paperQuestion.setPaperPath(questionPath);
            paperQuestionMapper.addPaperQuestion(paperQuestion);

            Paper paperAnswer = new Paper();
            paperAnswer.setUserId(userId);
            paperAnswer.setPaperName(answerName + ".doc");
            paperAnswer.setPaperPath(answerPath);
            paperAnswerMapper.addPaperAnswer(paperAnswer);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }

    @Override
    public List<PaperVo> paperToPaperVo(List<Paper> paperList) {
        List<PaperVo> paperVoList = new ArrayList<>();
        paperList.forEach(paper -> {
            PaperVo paperVo = new PaperVo();
            BeanUtils.copyProperties(paper, paperVo);
            // 转换时间为字符串
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(paper.getCreateTime());
            String createTime = simpleDateFormat.format(paper.getCreateTime());
            paperVo.setCreateTime(createTime);
            User user = userMapper.getUserById(paper.getUserId());
            if (user != null) {
                paperVo.setUserName(user.getUserName());
            }
            paperVoList.add(paperVo);
        });
        return paperVoList;
    }

    @Override
    public List<Paper> getPaperQuestionByName(String questionName) {
        return paperQuestionMapper.getPaperQuestionByName(questionName);
    }

    @Override
    public List<Paper> getPaperAnswerByName(String answerName) {
        return paperAnswerMapper.getPaperAnswerByName(answerName);
    }

}
