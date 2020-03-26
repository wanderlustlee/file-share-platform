package com.ncu.xzx;

import org.apache.poi.xwpf.usermodel.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

@SpringBootApplication
@MapperScan("com.ncu.xzx.mapper")
public class FileSharePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileSharePlatformApplication.class, args);


        final String path = "/Users/vivo/Desktop/test.doc";

        XWPFDocument doc = new XWPFDocument();// 创建Word文件

        // 1. 创建段落
        XWPFParagraph p = doc.createParagraph();// 新建一个段落
        p.setAlignment(ParagraphAlignment.CENTER);// 设置段落的对齐方式
        p.setBorderBottom(Borders.DOUBLE);//设置下边框
        p.setBorderTop(Borders.DOUBLE);//设置上边框
        p.setBorderRight(Borders.DOUBLE);//设置右边框
        p.setBorderLeft(Borders.DOUBLE);//设置左边框

        //1.1 标题
        XWPFRun r = p.createRun();//创建段落文本
        r.setText("POI创建的Word段落文本");
        r.setBold(true);//设置为粗体

        // 1.2 正文段落
        p = doc.createParagraph();// 新建一个段落
        r = p.createRun();
        r.setText("POI读写Excel功能强大、操作简单。");
        r.addBreak();
        r.setText("第一行");
        r.addBreak();
        r.setText("第二行");
        r.addBreak();
        r.setText("第san行");

        try {
            FileOutputStream out = new FileOutputStream(path);
            doc.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
