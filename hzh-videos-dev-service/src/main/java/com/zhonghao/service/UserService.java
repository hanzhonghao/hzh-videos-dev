package com.zhonghao.service;

import com.zhonghao.pojo.Users;

/**
 * Created by 小豪 on 2018/7/9.
 */
public interface UserService {

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 保护用户（用户注册）
     * @param user
     */
    public void saveUser(Users user);

    /**
     * @Description: 用户登录，根据用户名和密码查询用户
     */
    public Users queryUserForLogin(String username, String password);

    /**
     * 用户修改信息
     */
    public void updateUserInfo(Users use);

    /**
     * @Description: 查询用户信息
     */
    public Users queryUserInfo(String userId);
}
