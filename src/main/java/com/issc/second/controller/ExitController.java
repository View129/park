package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.Exitus;
import com.issc.second.dto.Msg;
import com.issc.second.service.ExitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exit")
public class ExitController {
    @Autowired
    ExitService exitService;

    //查询所有入口信息
    @RequestMapping(value = "/list",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String entranceList(){
        Msg msg = exitService.exitList();
        return JSON.toJSONString(msg);
    }

    //增加或修改入口信息
    @RequestMapping({"/update","save"})
    @ResponseBody
    public String entranceModify(Exitus exitus){
        Msg<Exitus> msg = exitService.modify(exitus);
        return JSON.toJSONString(msg);
    }

    //根据id删除出口信息
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteExit(Long id) {
        Msg msg = exitService.deleteExit(id);
        return JSON.toJSONString(msg);
    }
}
