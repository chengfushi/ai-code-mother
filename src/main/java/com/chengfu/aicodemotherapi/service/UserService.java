package com.chengfu.aicodemotherapi.service;

import com.chengfu.aicodemotherapi.model.dto.user.UserEditRequest;
import com.chengfu.aicodemotherapi.model.dto.user.UserQueryRequest;
import com.chengfu.aicodemotherapi.model.vo.user.LoginUserVO;
import com.chengfu.aicodemotherapi.model.vo.user.UserVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.chengfu.aicodemotherapi.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 *  服务层。
 *
 * @author Chengfu
 */
public interface UserService extends IService<User> {

    /**
     * @param userPassword  密码
     * @param checkPassword 校验密码
     * @description: 用户注册
     * @author: Chengfu Shi
     * @date: 2025/7/29 14:27
     * @param: userAccount 账号
     * @return: long 用户id
     **/
    long userRegister(String userAccount, String userPassword, String checkPassword);


    String getEncryptPassword(String userPassword);

    /**
     * 获取脱敏的已登录用户信息
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 编辑用户
     *
     * @param userEditRequest
     * @param request
     * @return
     */
    boolean userEdit(UserEditRequest userEditRequest, HttpServletRequest request);


    UserVO getUserVO(User user);

    List<UserVO> getUserVOList(List<User> userList);

    QueryWrapper getQueryWrapper(UserQueryRequest userQueryRequest);
}
