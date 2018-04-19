package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.DataGrid;
import com.issc.second.entity.Msg;
import com.issc.second.entity.User;
import com.issc.second.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping
    public String login(){
        return "userList";
    }

    //查询所有用户信息
    @RequestMapping(value = "/list",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String userList(@RequestParam(defaultValue ="1") String page, @RequestParam(defaultValue = "10") String rows,
                           @RequestParam(defaultValue = "id") String sort, @RequestParam(defaultValue = "asc") String order){
        Page<User> msg = userService.userList(page,rows,sort,order);

        DataGrid dataGrid = new DataGrid<>();
        dataGrid.setRows(msg.getContent());
        dataGrid.setTotal(msg.getTotalElements());

        return JSON.toJSONString(dataGrid);
    }

    //验证登录信息
    @RequestMapping("/login")
    @ResponseBody
    public String login(String userName,String password){
        Msg<User> msg = userService.login(userName,password);
        return JSON.toJSONString(msg);
    }


    //添加或修改用户信息
    @RequestMapping({"/update","/save"})
    @ResponseBody
    public String modifyUser(User user){
        Msg<User>msg = userService.modifyUser(user);
        return JSON.toJSONString(msg);
    }

    //新增用户，判断用户名是否重复
    @ResponseBody
    @RequestMapping("/insert")
    public String insertUser(User user){
        User user1 = userService.findByUsername(user.getUserName());
        Msg msg = null;
        if(user1==null) {
            msg = userService.modifyUser(user);
        }
        return JSON.toJSONString(msg);
    }

    //根据id删除用户
    @ResponseBody
    @RequestMapping("/delete")
    public String deleteUser(List<Long>list){
        System.out.println(list);
        Msg msg = userService.deleteUser(list);
        return JSON.toJSONString(msg);
    }
}

