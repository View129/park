package com.issc.second.service;

import com.issc.second.dao.EntranceDao;
import com.issc.second.entity.Entrance;
import com.issc.second.dto.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntranceService {

    @Autowired
    EntranceDao entranceDao;

    //查询所有入口信息
    public Msg<Entrance> entranceList(){
        List<Entrance>list = entranceDao.findAll();
        Msg msg = null;
        if(list.size()>0){
            msg = Msg.setSuccess();
            msg.add("list",list);
        }else{
            msg =Msg.setError();
        }
        return msg;
    }

    //增加或修改入口信息
    public Msg<Entrance> modify(Entrance entrance){
        Entrance entrance1 = entranceDao.save(entrance);
        Msg msg = null;
        if(entrance1!=null){
            msg = Msg.setSuccess();
        }else {
            msg = Msg.setError();
        }
        return msg;
    }

    //根据id删除入口信息
    public Msg deleteEntrance(Long id){
        Msg msg = null;
        try{
            entranceDao.delete(id);
        }catch (Exception e){
            msg = Msg.setError();
            return msg;
        }
        msg = Msg.setSuccess();
        return msg;
    }
}
