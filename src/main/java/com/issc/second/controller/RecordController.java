package com.issc.second.controller;

import com.alibaba.fastjson.JSON;
import com.issc.second.entity.DataGrid;
import com.issc.second.entity.Record;
import com.issc.second.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping("/record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @RequestMapping("/list")
    @ResponseBody
    public String recordList(Long carId, Date inTime, Date outTime, @RequestParam(defaultValue ="1") String page, @RequestParam(defaultValue = "10") String rows,
                             @RequestParam(defaultValue = "id") String sort, @RequestParam(defaultValue = "asc") String order){
        Page<Record> page1 = recordService.recordList(carId,inTime,outTime,page, rows, sort, order);

        DataGrid dataGrid = new DataGrid<>();
        dataGrid.setRows(page1.getContent());
        dataGrid.setTotal(page1.getTotalElements());
        return JSON.toJSONString(dataGrid);
    }

}
