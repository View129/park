package com.issc.second.service;

import com.issc.second.dao.MemberOrderDao;
import com.issc.second.entity.MemberOrder;
import com.issc.second.dto.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberOrderService {
    @Autowired
    MemberOrderDao memberOrderDao;

    //查询所有月租户订单信息
    public Msg memberOrderList(){
        List<MemberOrder> list = memberOrderDao.findAll();
        Msg msg = null;
        if(list.size()>0){
            msg = Msg.setSuccess();
            msg.add("list",list);
        }else{
            msg = Msg.setError();
        }
        return msg;
    }

    //增加或修改月租户订单信息
    public Msg modifyMemberOrder(MemberOrder memberOrder){
        MemberOrder memberOrder1 = memberOrderDao.save(memberOrder);
        Msg msg = null;
        if(memberOrder1!=null){
            msg = Msg.setSuccess();
        }else{
            msg = Msg.setError();
        }
        return msg;
    }

    //删除月租户订单信息
    public Msg deleteMemberOrder(Long id){
        Msg msg = null;
        try{
            memberOrderDao.delete(id);
        }catch(Exception e){
            msg = Msg.setError();
        }
        msg = Msg.setSuccess();
        return msg;
    }

}
