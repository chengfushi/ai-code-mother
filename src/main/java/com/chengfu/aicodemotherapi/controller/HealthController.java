package com.chengfu.aicodemotherapi.controller;

import com.chengfu.aicodemotherapi.common.BaseResponse;
import com.chengfu.aicodemotherapi.common.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Chengfu Shi
 * @Description: 健康检查
 **/
@RestController
@RequestMapping("/health")
public class HealthController {

    @PostMapping("/")
    public BaseResponse<String> healthCheck(){
        return ResultUtils.success("ok");
    }
}

