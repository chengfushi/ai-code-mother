package com.chengfu.aicodemotherapi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.chengfu.model.entity.User;
import com.chengfu.aicodemotherapi.mapper.UserMapper;
import com.chengfu.aicodemotherapi.service.UserService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author Chengfu
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService{

}
