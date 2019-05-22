package com.zhonghao.controller;

import com.zhonghao.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhonghao
 * @Date:Created in 23:072019/5/22 0022
 */
@RestController
public class BasicController {

    @Autowired
    public RedisOperator redis;

    public static final  String USER_REDIS_SESSION="user-redis-session";
}
