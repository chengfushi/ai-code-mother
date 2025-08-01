package com.chengfu.aicodemotherapi.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Chengfu Shi
 * @Description: 应用更新请求类
 **/
@Data
public class AppUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 应用名称
     */
    private String appName;

    private static final long serialVersionUID = 1L;
}


