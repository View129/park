package com.issc.second.service;

import com.issc.second.dao.CarSeatDao;
import com.issc.second.entity.CarSeat;
import com.issc.second.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarSeatService {

    @Autowired
    CarSeatDao carSeatDao;

    //查询所有车位信息
    public List<CarSeat> carSeatList(){
        List<CarSeat>list = carSeatDao.findAll();
        return list;
    }

    //增加或修改车位信息
    public CarSeat modifyCarSeat(CarSeat carSeat){
        CarSeat carSeat1 = carSeatDao.save(carSeat);
        return carSeat1;
    }

    //删除车位信息
    public Msg deleteCarSeat(Long id){
        Msg msg = null;
        try{
            carSeatDao.delete(id);
        }catch(Exception e){
            msg = Msg.ERROR;
        }
        msg = Msg.SUCCESS;
        return msg;
    }
}
