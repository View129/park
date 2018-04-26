package com.issc.second.service;

import com.issc.second.dao.BlackListDao;
import com.issc.second.entity.BlackList;
import com.issc.second.dto.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlackListService {
    @Autowired
    BlackListDao blackListDao;

    /**
     * 根据车牌查询是否是黑名单
     * @param cardId
     * @return  是黑名单车辆 返回 1  不是 返回 0
     */
    public Msg find(String cardId){
        BlackList blackList = blackListDao.findByCardId(cardId);
        if(blackList!=null){
            return Msg.setSuccess();
        }else {
            return Msg.setError();
        }
    }

    /**
     * 加入黑名单
     * @param cardId
     * @param description
     * @return
     */
    public Msg add(String cardId,String description){
        BlackList blackList= new BlackList();
        blackList.setCardId(cardId);
        blackList.setDescription(description);
        BlackList bk = blackListDao.save(blackList);
        if (bk!=null){
            return Msg.setSuccess();
        }else{
            return Msg.setError();
        }
    }

    /**
     * 删除黑名单
     * @param id
     * @return
     */
    public Msg del(Long id){
        try {
            blackListDao.delete(id);
        }catch (Exception e){
            return Msg.setSuccess();
        }
            return Msg.setError();

    }
}
