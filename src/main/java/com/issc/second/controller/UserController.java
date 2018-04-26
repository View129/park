package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.dto.DataGrid;
import com.issc.second.dto.Msg;
import com.issc.second.entity.User;
import com.issc.second.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //登陆页面
    @RequestMapping
    public String login(){
        return "login";
    }

    //查询所有用户信息
    @RequestMapping(value = "/list",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String userList(@RequestParam(required = false)String userName,@RequestParam(required = false)String rank,
                           @RequestParam(defaultValue ="1") String page, @RequestParam(defaultValue = "10") String rows,
                           @RequestParam(defaultValue = "id") String sort, @RequestParam(defaultValue = "asc") String order){
        Page<User> msg = userService.userList(userName,rank,page,rows,sort,order);

        DataGrid dataGrid = new DataGrid<>();
        dataGrid.setRows(msg.getContent());
        dataGrid.setTotal(msg.getTotalElements());

        return JSON.toJSONString(dataGrid);
    }

    //验证登录信息
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user,HttpSession httpSession){
        Msg<User> msg = userService.login(user.getUserName(),user.getPassword());
        if(msg.getCode()==1){
            httpSession.setAttribute("user",user);
        }
        return JSON.toJSONString(msg);
    }
    //ajax获取登陆的用户
    @RequestMapping("/session")
    @ResponseBody
    public String seesion(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        Msg<User> msg;
        if(user!=null){
            msg = Msg.setSuccess();
        }else {
            msg = Msg.setError();
        }
        msg.setData((User) httpSession.getAttribute("user"));
        return JSON.toJSONString(msg);
    }
    //ajax退出登陆
    @RequestMapping("/exit")
    @ResponseBody
    public String exit(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        Msg<User> msg;
        if(user!=null){
            httpSession.setAttribute("user",null);
            msg = Msg.setSuccess();
        }else {
            msg = Msg.setError();
        }
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

    //批量删除用户
    @ResponseBody
    @RequestMapping("/delete")


    public String deleteUser(@RequestBody List<User> list){
        /*@RequestParam(required = false) String list
        Msg msg = userService.deleteUser(JSON.parseArray(list,User.class));*/
        Msg msg = userService.deleteUser(list);
        return JSON.toJSONString(msg);
    }


}

