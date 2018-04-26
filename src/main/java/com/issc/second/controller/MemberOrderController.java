package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.MemberOrder;
import com.issc.second.dto.Msg;
import com.issc.second.service.MemberOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberOrderController {
    @Autowired
    MemberOrderService memberOrderService;

    // 查询所有月租户订单信息
    @RequestMapping("/list")
    @ResponseBody
    public String memberOrderList(){
        Msg msg = memberOrderService.memberOrderList();
        return JSON.toJSONString(msg);
    }

    // 增加或修改月租户订单信息
    @RequestMapping({"/save","update"})
    @ResponseBody
    public String modifyMemberOrder(MemberOrder memberOrder){
        Msg msg = memberOrderService.modifyMemberOrder(memberOrder);
        return JSON.toJSONString(msg);
    }

    //删除月租户订单信息
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteMemberOrder(Long id){
        Msg msg = memberOrderService.deleteMemberOrder(id);
        return JSON.toJSONString(msg);
    }
}
