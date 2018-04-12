package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.Msg;
import com.issc.second.entity.TemporaryOrder;
import com.issc.second.service.TemporaryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/temporaryOrder")
public class TemporaryOrderController {
    @Autowired
    TemporaryOrderService temporaryOrderService;

    // 查询所有临时用户订单信息
    @RequestMapping("/list")
    @ResponseBody
    public String temporaryOrderList(){
        Msg msg = temporaryOrderService.temporaryOrderList();
        return JSON.toJSONString(msg);
    }

    // 增加或修改临时用户订单信息
    @RequestMapping({"/save","update"})
    @ResponseBody
    public String modifyTemporaryOrder(TemporaryOrder temporaryOrder){
        Msg msg = temporaryOrderService.modifyTemporaryOrder(temporaryOrder);
        return JSON.toJSONString(msg);
    }

    //删除临时用户订单信息
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteTemporaryOrder(Long id){
        Msg msg = temporaryOrderService.deleteTemporaryOrder(id);
        return JSON.toJSONString(msg);
    }
}
