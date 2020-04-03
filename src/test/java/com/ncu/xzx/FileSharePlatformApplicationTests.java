package com.ncu.xzx;

import com.ncu.xzx.service.PaperService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FileSharePlatformApplicationTests {

    @Autowired
    PaperService paperService;

    @Test
    void contextLoads() {
        System.out.println(paperService.countAllPaperAnswers());
    }

}
