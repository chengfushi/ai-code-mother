package com.chengfu.aicodemotherapi.core.parser;

/**
 * @Author: Chengfu Shi
 * @Description: 代码解析器策略接口
 **/
public interface CodeParser<T> {

    /*
     * 解析代码内容
     *
     * @author: Chengfu Shi
     * @param: codeContent 原始代码内容
     * @return: 解析后内容
     **/
    T parseCode(String codeContent);
}
