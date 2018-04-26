package com.issc.second.service;

import com.issc.second.dao.MemberCarDao;
import com.issc.second.entity.MemberCar;
import com.issc.second.dto.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberCarService {
    @Autowired
    MemberCarDao memberCarDao;

    /**
     * 显示租户车辆信息
     * @return
     */
    public Msg<MemberCar> list(){
        List<MemberCar> list= memberCarDao.findAll();
        Msg msg = null;
        if(list.size()>0){
            msg = Msg.setSuccess();
            msg.add("list",list);
        }else{
            msg = Msg.setError();
        }
        return msg;
    }

    /**
     * 删除商家车辆信息
     * @param id
     * @return
     */
    public Msg<MemberCar> del(Long id){
        Msg msg = null;
        try{
            memberCarDao.delete(id);
        }catch (Exception e){
            msg = Msg.setError();
            return msg;
        }
        msg = Msg.setSuccess();
        return  msg;
    }

    /**
     * 保存或修改商家车辆信息
     * @param memberCar
     * @return
     */
    public Msg<MemberCar> add(MemberCar memberCar){
        Msg msg = null;
        MemberCar bussinessCar1 = memberCarDao.save(memberCar);
        if(bussinessCar1!=null){
            msg = Msg.setSuccess();
        }else {
            msg = Msg.setError();
            return msg;
        }
        return msg;
    }
}
