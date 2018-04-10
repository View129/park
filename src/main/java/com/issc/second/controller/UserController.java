package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.Msg;
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
    public String userList(){
        List<User> list = userService.userList();
        return JSON.toJSONString(Msg.SUCCESS.add("list",list));
    }

    //验证登录信息
    @RequestMapping("/login")
    @ResponseBody
    public String login(String userName,String password){
        User user = userService.login(userName,password);
        Msg response = null;
        if(user!=null){
            response = Msg.SUCCESS;
        }else{
            response = Msg.ERROR;
        }
        return JSON.toJSONString(response);
    }
}
