package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.Member;
import com.issc.second.entity.Msg;
import com.issc.second.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    //显示所有
    @RequestMapping(value = "/list",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String list(){
        Msg msg = memberService.list();
        return JSON.toJSONString(msg);
    }

    //删除
    @RequestMapping(value = "/del",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String del(String id){
        System.out.println(id);
        Msg msg =  memberService.del(Long.parseLong(id));
        return JSON.toJSONString(msg);
    }
    //新增
    @RequestMapping(value = "/add",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String add(Member member){
        Msg msg =  memberService.add(member);
        return JSON.toJSONString(msg);
    }
}
