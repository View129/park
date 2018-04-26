package com.issc.second.service;


import com.issc.second.dao.TemporaryOrderDao;
import com.issc.second.dto.Msg;
import com.issc.second.entity.TemporaryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporaryOrderService {

    @Autowired
    TemporaryOrderDao temporaryOrderDao;

    //查询所有临时用户订单信息
    public Msg temporaryOrderList(){
        List<TemporaryOrder> list = temporaryOrderDao.findAll();
        Msg msg = null;
        if(list.size()>0){
            msg = Msg.setSuccess();
            msg.add("list",list);
        }else{
            msg = Msg.setError();
        }
        return msg;
    }

    //增加或修改临时用户订单信息
    public Msg modifyTemporaryOrder(TemporaryOrder temporaryOrder){
        TemporaryOrder temporaryOrder1 = temporaryOrderDao.save(temporaryOrder);
        Msg msg = null;
        if(temporaryOrder1!=null){
            msg = Msg.setSuccess();
        }else{
            msg = Msg.setError();
        }
        return msg;
    }

    //删除临时用户订单信息
    public Msg deleteTemporaryOrder(Long id){
        Msg msg = null;
        try{
            temporaryOrderDao.delete(id);
        }catch(Exception e){
            msg = Msg.setError();
        }
        msg = Msg.setSuccess();
        return msg;
    }

}
