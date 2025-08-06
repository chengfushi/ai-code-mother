package com.chengfu.aicodemotherapi.ai.model.message;

/**
 * @Author: Chengfu Shi
 * @Description: 流式消息响应基类
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreamMessage {
    private String type;
}


