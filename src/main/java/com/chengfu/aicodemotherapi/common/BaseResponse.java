package com.chengfu.aicodemotherapi.common;

import com.chengfu.aicodemotherapi.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Chengfu Shi
 * @Description: 全局响应类
 **/
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}


