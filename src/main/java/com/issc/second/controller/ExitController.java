package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.Exitus;
import com.issc.second.entity.Msg;
import com.issc.second.service.ExitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/exit")
public class ExitController {
    @Autowired
    ExitService exitService;

    //查询所有入口信息
    @RequestMapping(value = "/list",produces= "text/html;charset=UTF-8")
    @ResponseBody
    public String entranceList(){
        List<Exitus>list = exitService.exitList();
        Msg msg = null;
        if(list!=null){
            msg = Msg.SUCCESS;
        }else{
            msg = Msg.ERROR;
        }
        msg.add("list",list);
        return JSON.toJSONString(msg);
    }

    //增加或修改入口信息
    @RequestMapping({"/update","save"})
    @ResponseBody
    public String entranceModify(Exitus exitus){
        Exitus exitus1 = exitService.modify(exitus);
        Msg msg = null;
        if(exitus1 !=null){
            msg = Msg.SUCCESS;
        }else {
            msg = Msg.ERROR;
        }
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
