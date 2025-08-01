package com.chengfu.aicodemotherapi.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Chengfu Shi
 * @Description: 应用生成请求类
 **/
@Data
public class AppAddRequest implements Serializable {

    /**
     * 应用初始化的 prompt
     */
    private String initPrompt;

    private static final long serialVersionUID = 1L;
}
