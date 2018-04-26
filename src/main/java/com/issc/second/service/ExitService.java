package com.issc.second.service;

import com.issc.second.dao.ExitDao;
import com.issc.second.entity.Exitus;
import com.issc.second.dto.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExitService {

    @Autowired
    ExitDao exitDao;

    //查询所有出口信息
    public Msg<Exitus> exitList(){
        List<Exitus>list = exitDao.findAll();
        Msg msg = null;
        if(list.size()>0){
            msg = Msg.setSuccess();
            msg.add("list",list);
        }else{
            msg =Msg.setError();
        }
        return msg;
    }

    //增加或修改出口信息
    public Msg<Exitus> modify(Exitus exitus){
        Exitus exitus1 = exitDao.save(exitus);
        Msg msg = null;
        if(exitus1 !=null){
            msg = Msg.setSuccess();
        }else {
            msg = Msg.setError();
        }
        return msg;
    }

    //根据id删除出口信息
    public Msg deleteExit(Long id){
        Msg msg = null;
        try{
            exitDao.delete(id);
        }catch (Exception e){
            msg = Msg.setError();
            return msg;
        }
        msg = Msg.setSuccess();
        return msg;
    }
}
