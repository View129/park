package com.issc.second.service;

import com.issc.second.dao.EntranceDao;
import com.issc.second.entity.Entrance;
import com.issc.second.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntranceService {

    @Autowired
    EntranceDao entranceDao;

    //查询所有入口信息
    public List<Entrance> entranceList(){
        List<Entrance>list = entranceDao.findAll();
        return list;
    }

    //增加或修改入口信息
    public Entrance modify(Entrance entrance){
        return entranceDao.save(entrance);
    }

    //根据id删除入口信息
    public Msg deleteEntrance(Long id){
        Msg msg = null;
        try{
            entranceDao.delete(id);
        }catch (Exception e){
            msg = Msg.ERROR;
            return msg;
        }
        msg = Msg.SUCCESS;
        return msg;
    }
}
