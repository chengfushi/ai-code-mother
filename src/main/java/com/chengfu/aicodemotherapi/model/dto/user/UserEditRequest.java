package com.chengfu.aicodemotherapi.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Chengfu Shi
 * @Description: 用户修改个人信息
 **/
@Data
public class UserEditRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;

    private String userAvatar;

    private String userProfile;


}

