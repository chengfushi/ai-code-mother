package com.chengfu.aicodemotherapi.service;

import com.chengfu.aicodemotherapi.model.dto.chathistory.ChatHistoryQueryRequest;
import com.chengfu.aicodemotherapi.model.entity.User;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.chengfu.aicodemotherapi.model.entity.ChatHistory;

import java.time.LocalDateTime;

/**
 *  服务层。
 *
 * @author Chengfu
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /*
     * 添加会话历史
     *
     * @author: Chengfu Shi
     * @param: appId 应用id
     * @param message 对话内容
     * @param messageType 对话类型
     * @param userId 用户id
     * @return:
     **/
    boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    /*
     * 删除会话历史
     *
     * @author: Chengfu Shi
     * @param: appId
     * @return:
     **/
    boolean deleteByAppId(Long appId);

    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);


    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);
}
