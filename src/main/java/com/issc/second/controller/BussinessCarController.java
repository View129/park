package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.BussinessCar;
import com.issc.second.dto.Msg;
import com.issc.second.service.BussinessCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bussinesscar")
public class BussinessCarController {

    @Autowired
    BussinessCarService bussinessCarService;

    //显示商家车辆信息
    @RequestMapping("/list")
    @ResponseBody
    public String bussinessCarList(){
        Msg msg = bussinessCarService.bussinessList();
        return JSON.toJSONString(msg);
    }

    //删除商家车辆信息
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteBussinessCar(Long id){
        Msg msg = bussinessCarService.deleteBussinesscar(id);
        return JSON.toJSONString(msg);
    }

    //新增或编辑车辆信息
    @RequestMapping({"/save","update"})
    @ResponseBody
    public String modifyBussinessCar(BussinessCar bussinessCar){
        Msg msg = bussinessCarService.modifyBussinesscar(bussinessCar);
        return JSON.toJSONString(msg);
    }
}
