package com.issc.second.service;

import com.issc.second.dao.BussinessCarDao;
import com.issc.second.entity.BussinessCar;
import com.issc.second.dto.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BussinessCarService {
    @Autowired
    BussinessCarDao bussinessCarDao;

    //显示商家车辆信息
    public Msg<BussinessCar> bussinessList(){
        List<BussinessCar>list= bussinessCarDao.findAll();
        Msg msg = null;
        if(list.size()>0){
            msg = Msg.setSuccess();
            msg.add("list",list);
        }else{
            msg = Msg.setError();
        }
        return msg;
    }

    //删除商家车辆信息
    public Msg<BussinessCar> deleteBussinesscar(Long id){
        Msg msg = null;
        try{
            bussinessCarDao.delete(id);
        }catch (Exception e){
            msg = Msg.setError();
            return msg;
        }
        msg = Msg.setSuccess();
        return  msg;
    }

    //保存或修改商家车辆信息
    public Msg<BussinessCar> modifyBussinesscar(BussinessCar bussinessCar){
        Msg msg = null;
        BussinessCar bussinessCar1 = bussinessCarDao.save(bussinessCar);
        if(bussinessCar1!=null){
            msg = Msg.setSuccess();
        }else {
            msg = Msg.setError();
            return msg;
        }
        return msg;
    }

}
