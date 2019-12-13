package com.wzk.dao;

import com.wzk.entity.User;

import java.util.Map;

/**
 * @program: ssm_MultipleDataSources_demo
 * @author: DANRAN2333
 * @create: 2019-12-06 13:29
 * @description:
 */
public interface UserDao {

    /**
     * 新增用户
     * @Param: [map]
     * @return: int
     * @Author: DANRAN2333
     * @Date: 2019/12/6 13:36
     */
    int addUser(User user);

    /**
     *  查询用户是否存在及信息是否正确
     * @Param: [map]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: DANRAN2333
     * @Date: 2019/12/6 13:36
     */
    Map<String,Object> login(Map map);
}
