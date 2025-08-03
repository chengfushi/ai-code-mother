package com.chengfu.aicodemotherapi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.chengfu.aicodemotherapi.model.entity.ChatHistory;
import com.chengfu.aicodemotherapi.mapper.ChatHistoryMapper;
import com.chengfu.aicodemotherapi.service.ChatHistoryService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author Chengfu
 */
@Service
public class ChatHistoryServiceImpl extends ServiceImpl<ChatHistoryMapper, ChatHistory>  implements ChatHistoryService{

}
