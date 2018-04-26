package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.dto.Msg;
import com.issc.second.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/blacklist")
public class BlackListController {

    @Autowired
    BlackListService blackListService;

    //按车牌查找 黑名单
    @RequestMapping("/find")
    @ResponseBody
    public String find(String cardId){
        Msg msg =  blackListService.find(cardId);
        return JSON.toJSONString(msg);
    }

    //新增黑名单
    @RequestMapping(value = "/add",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String add(String cardId,String description){
        Msg msg =  blackListService.add(cardId,description);
        return JSON.toJSONString(msg);
    }

    //删除黑名单
    @RequestMapping(value = "/del",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String del(String id){
        System.out.println(id);
        Msg msg =  blackListService.del(Long.parseLong(id));
        return JSON.toJSONString(msg);
    }
}
