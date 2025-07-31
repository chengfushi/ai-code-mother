package com.chengfu.aicodemotherapi.ai;

import com.chengfu.aicodemotherapi.ai.model.HtmlCodeResult;
import com.chengfu.aicodemotherapi.ai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Chengfu Shi
 * @Description: ai应用生成器测试
 **/
@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult result = aiCodeGeneratorService.generateHtmlCode("做个程序员chengfu的工作记录小工具,大约20行代码以内");
        Assertions.assertNotNull(result);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult multiFileCode = aiCodeGeneratorService.generateMultiFileCode("做个程序员chengfu的留言板，大约20行代码以内");
        Assertions.assertNotNull(multiFileCode);
    }


}


