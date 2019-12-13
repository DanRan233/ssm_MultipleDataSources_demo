package com.wzk.controller;

import com.wzk.entity.User;
import com.wzk.service.UserServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: ssm_MultipleDataSources_demo
 * @author: DANRAN2333
 * @create: 2019-12-06 13:41
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceIF userServiceIF;


    @RequestMapping("/register")
    public String addUser(User user){
        System.out.println(user);
        userServiceIF.addUser(user);
        return null;
    }


}
