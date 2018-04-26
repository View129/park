package com.issc.second.service;

import com.issc.second.dao.CarSeatDao;
import com.issc.second.entity.CarSeat;
import com.issc.second.dto.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarSeatService {

    @Autowired
    CarSeatDao carSeatDao;

    //查询所有车位信息
    public Msg<CarSeat> carSeatList(){
        List<CarSeat>list = carSeatDao.findAll();
        Msg msg = null;
        if(list.size()>0){
            msg = Msg.setSuccess();
            msg.add("list",list);
        }else{
            msg =Msg.setError();
        }
        return msg;
    }

    //增加或修改车位信息
    public Msg<CarSeat> modifyCarSeat(CarSeat carSeat){
        CarSeat carSeat1 = carSeatDao.save(carSeat);
        Msg msg = null;
        if(carSeat1!=null){
            msg = Msg.setSuccess();
        }else{
            msg = Msg.setError();
        }
        return msg;
    }

    //删除车位信息
    public Msg deleteCarSeat(Long id){
        Msg msg = null;
        try{
            carSeatDao.delete(id);
        }catch(Exception e){
            msg = Msg.setError();
            return msg;
        }
        msg = Msg.setSuccess();
        return msg;
    }
}
