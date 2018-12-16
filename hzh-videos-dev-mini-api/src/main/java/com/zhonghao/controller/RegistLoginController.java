package com.zhonghao.controller;

import com.zhonghao.pojo.Users;

import com.zhonghao.service.UserService;
import com.zhonghao.utils.IMoocJSONResult;
import com.zhonghao.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 小豪 on 2018/6/21.
 */
@RestController
@Api(value = "用户注册登录的接口",tags = {"注册和登录的controller"}) //Swagger2用到的
public class RegistLoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    @ApiOperation(value = "用户登录的接口",notes = "用户注册的接口")
    public IMoocJSONResult regist(@RequestBody Users user) throws Exception {

        //1.判断用户名和密码不能为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return IMoocJSONResult.errorMsg("用户名和密码不能为空");
        }
        //2.判断用户名是否存在
        boolean usernameIsExist = userService.queryUsernameIsExist(user.getUsername());
        //3.保存用户，注册信息
        if (!usernameIsExist) {
            user.setNickname(user.getUsername());
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            user.setFansCounts(0);
            user.setReceiveLikeCounts(0);
            user.setFollowCounts(0);
            userService.saveUser(user);
        } else {
            return IMoocJSONResult.errorMsg("用户名密码已经存在，请换一个再试试");
        }
//        userService.saveUser(user);
        user.setPassword("");
        return IMoocJSONResult.ok(user);
    }

}
