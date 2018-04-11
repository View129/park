package com.issc.second.controller;


import com.alibaba.fastjson.JSON;
import com.issc.second.entity.MemberCar;
import com.issc.second.entity.Msg;
import com.issc.second.service.MemberCarService;
import com.issc.second.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("membercar")
public class MemberCarController {

    @Autowired
    MemberCarService memberCarService;

    //显示租户车辆信息
    @RequestMapping("/list")
    @ResponseBody
    public String list(){
        Msg msg = memberCarService.list();
        return JSON.toJSONString(msg);
    }

    //删除商家车辆信息
    @RequestMapping("/del")
    @ResponseBody
    public String del(Long id){
        Msg msg = memberCarService.del(id);
        return JSON.toJSONString(msg);
    }

    //新增或编辑车辆信息
    @RequestMapping({"/save","/update"})
    @ResponseBody
    public String add(MemberCar memberCar){
        Msg msg = memberCarService.add(memberCar);
        return JSON.toJSONString(msg);
    }
}
