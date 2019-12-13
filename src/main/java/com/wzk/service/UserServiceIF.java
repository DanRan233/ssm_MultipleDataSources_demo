package com.wzk.service;

import com.wzk.entity.User;

import java.util.Map;

/**
 * @program: ssm_MultipleDataSources_demo
 * @author: DANRAN2333
 * @create: 2019-12-06 13:39
 * @description:
 */
public interface UserServiceIF {

    /**
     *  新增用户
     * @Param: [map]
     * @return: int
     * @Author: DANRAN2333
     * @Date: 2019/12/6 13:44
     */
    int addUser(User user);


    /**
     *  用户登录
     * @Param: [map]
     * @return: java.util.Map
     * @Author: DANRAN2333
     * @Date: 2019/12/6 13:45
     */
    Map login(Map map);
}
