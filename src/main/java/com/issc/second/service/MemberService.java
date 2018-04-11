package com.issc.second.service;

import com.issc.second.dao.MemberDao;
import com.issc.second.entity.Member;
import com.issc.second.entity.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 月租户
 */
@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    /**
     * 新增月住户
     * @return
     */
    public Msg add(Member member){
        Member mb = memberDao.save(member);
        if(mb!=null){
            return Msg.SUCCESS;
        }else{
            return Msg.ERROR;
        }
    }

    /**
     * 删除月租户
     * @param id
     * @return
     */
    public Msg del(Long id){
        try {
            memberDao.delete(id);
        }catch (Exception e){
            return Msg.ERROR;
        }
        return Msg.SUCCESS;

    }

    /**
     * 查询所有月租户
     * @return
     */
    public Msg<Member> list(){
        List<Member> li = memberDao.findAll();
        Msg msg = null;
        if(li.size()>0){
            msg=Msg.SUCCESS;
        }else {
            msg=Msg.ERROR;
        }
        msg.add("list",li);
        return msg;
    }



}
