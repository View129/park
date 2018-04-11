package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.CarSeat;
import com.issc.second.entity.Msg;
import com.issc.second.service.CarSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/carseat")
public class CarSeatController {

    @Autowired
    CarSeatService carSeatService;

    //查询所有车位信息
    @RequestMapping(value = "/list",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String carSeatList(){
        Msg msg = carSeatService.carSeatList();
        return JSON.toJSONString(msg);
    }

    //增加或修改车位信息
    @RequestMapping({"/update","/save"})
    @ResponseBody
    public String modifyCarSeat(CarSeat carSeat){
        Msg<CarSeat>msg = carSeatService.modifyCarSeat(carSeat);
        return JSON.toJSONString(msg);
    }

    //删除车位信息
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteCarSeat(Long id){
        Msg msg = carSeatService.deleteCarSeat(id);
        return JSON.toJSONString(msg);
    }
}
