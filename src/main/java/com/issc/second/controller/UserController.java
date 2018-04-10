package com.issc.second.controller;

import com.issc.second.entity.User;
import com.issc.second.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //查询所有用户信息
    @RequestMapping("/list")
    @ResponseBody
    public List<User> userList(){
        List<User> list = userService.userList();
        return list;
    }
}
