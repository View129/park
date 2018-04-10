package com.issc.second.service;

import com.issc.second.dao.ExitDao;
import com.issc.second.entity.Exitus;
import com.issc.second.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExitService {

    @Autowired
    ExitDao exitDao;

    //查询所有出口信息
    public List<Exitus> exitList(){
        List<Exitus>list = exitDao.findAll();
        return list;
    }

    //增加或修改出口信息
    public Exitus modify(Exitus exitus){
        return exitDao.save(exitus);
    }

    //根据id删除出口信息
    public Msg deleteExit(Long id){
        Msg msg = null;
        try{
            exitDao.delete(id);
        }catch (Exception e){
            msg = Msg.ERROR;
            return msg;
        }
        msg = Msg.SUCCESS;
        return msg;
    }
}
