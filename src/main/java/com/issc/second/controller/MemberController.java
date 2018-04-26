package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.DataGrid;
import com.issc.second.entity.Member;
import com.issc.second.entity.Msg;
import com.issc.second.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    //显示所有
    @RequestMapping(value = "/list",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String list(Member member,
                       @RequestParam(defaultValue ="1") String page, @RequestParam(defaultValue = "10") String rows,
                       @RequestParam(defaultValue = "id") String sort, @RequestParam(defaultValue = "asc") String order){
        Page msg = memberService.list(member,page,rows,sort,order);

        DataGrid dataGrid = new DataGrid<>();
        dataGrid.setRows(msg.getContent());
        dataGrid.setTotal(msg.getTotalElements());


        return JSON.toJSONString(dataGrid);
    }

    //删除3///
    @RequestMapping(value = "/del",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String del(String id){
        Msg msg =  memberService.del(Long.parseLong(id));
        return JSON.toJSONString(msg);
    }
    //新增
    @RequestMapping(value = {"/save","/update"},produces="text/html;charset=UTF-8")
    @ResponseBody
    public String add(Member member){
        Msg msg =  memberService.add(member);
        return JSON.toJSONString(msg);
    }
}
