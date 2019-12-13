package com.wzk.service.impl;

import com.wzk.dao.UserDao;
import com.wzk.entity.User;
import com.wzk.service.UserServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: ssm_MultipleDataSources_demo
 * @author: DANRAN2333
 * @create: 2019-12-06 13:39
 * @description:
 */
@Service
public class UserServiceImpl implements UserServiceIF {

    @Autowired
    UserDao userDao;

    @Override
    public int addUser(User user) {
        int i = 0;
        try {
            i = userDao.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Map login(Map map) {
        Map<String, Object> list = new LinkedHashMap<>();
        String x = null;
        if (map == null) {
            x = "1";
        } else
            x = "2";
        //jdk 13 新特性 switch的简化

        try {
            list = userDao.login(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
