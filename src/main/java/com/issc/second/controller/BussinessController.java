package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.Bussiness;
import com.issc.second.dto.Msg;
import com.issc.second.service.BussinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bussiness")
public class BussinessController {
    @Autowired
    BussinessService bussinessService;

    //显示所有
    @RequestMapping("/list")
    @ResponseBody
    public String list(){
        Msg msg = bussinessService.list();
        return JSON.toJSONString(msg);
    }

    //删除
    @RequestMapping(value = "/del",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String del(String id){
        System.out.println(id);
        Msg msg =  bussinessService.del(Long.parseLong(id));
        return JSON.toJSONString(msg);
    }
    //新增
    @RequestMapping(value = "/add",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String add(Bussiness bussiness){
        Msg msg =  bussinessService.add(bussiness);
        return JSON.toJSONString(msg);
    }
}
