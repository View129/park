package com.issc.second.service;

import com.issc.second.dao.BussinessDao;
import com.issc.second.entity.Bussiness;
import com.issc.second.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BussinessService {
    @Autowired
    BussinessDao bussinessDao;

    /**
     * 新增商家用户
     * @param bussinessName
     * @param description
     * @param telephone
     * @return
     */
    public String add(String bussinessName,String description,String telephone){
        Bussiness bussiness = new Bussiness();
        bussiness.setBussinessName(bussinessName);
        bussiness.setDescription(description);
        bussiness.setTelephone(telephone);
        Bussiness bs = bussinessDao.save(bussiness);
        if (bs!=null){
            return "成功";
        }else{
            return "失败";
        }
    }

    /**
     * 删除商家用户
     * @param id
     * @return
     */
    public String del(Long id){
        try {
            bussinessDao.delete(id);
        }catch (Exception e){
            return "失败";
        }
        return "成功";

    }

    /**
     * 显示所有商家用户信息
     * @return
     */
    public Msg<Bussiness> list(){
        List<Bussiness> li = bussinessDao.findAll();
        Msg msg = null;
        if(li.size()>0){
            msg=Msg.setSuccess();
        }else {
            msg=Msg.setError();
        }
        msg.add("list",li);
        return msg;
    }
}
