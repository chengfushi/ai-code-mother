package com.chengfu.aicodemotherapi.ai;

import com.chengfu.aicodemotherapi.ai.model.HtmlCodeResult;
import com.chengfu.aicodemotherapi.ai.model.MultiFileCodeResult;
import dev.langchain4j.service.SystemMessage;

/**
 * @Author: Chengfu Shi
 * @Description: ai服务接口
 **/
public interface AiCodeGeneratorService {

    /*
     * 生成原生HTML代码
     *
     * @author: Chengfu Shi
     * @param: userMessage 用户消息
     * @return: 代码输出
     **/
    @SystemMessage(fromResource = "prompt/codegen-html-system-prompt.txt")
    HtmlCodeResult generateHtmlCode(String userMessage);

    /*
     * 生成多文件代码
     *
     * @author: Chengfu Shi
     * @param: userMessage
     * @return: 代码输出
     **/
    @SystemMessage(fromResource = "prompt/codegen-multi-file-system-prompt.txt")
    MultiFileCodeResult generateMultiFileCode(String userMessage);


}
