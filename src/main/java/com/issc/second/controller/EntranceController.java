package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.Entrance;
import com.issc.second.entity.Msg;
import com.issc.second.service.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/entrance")
public class EntranceController {
    @Autowired
    EntranceService entranceService;

    //查询所有入口信息
    @RequestMapping(value = "/list",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String entranceList(){
        Msg<Entrance>msg = entranceService.entranceList();
        return JSON.toJSONString(msg);
    }

    //增加或修改入口信息
    @RequestMapping({"/update","/save"})
    @ResponseBody
    public String entranceModify(Entrance entrance){
        Msg<Entrance>msg = entranceService.modify(entrance);
        return JSON.toJSONString(msg);
    }

    //根据id删除入口信息
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteEntrance(Long id) {
        Msg msg = entranceService.deleteEntrance(id);
        return JSON.toJSONString(msg);
    }
}
