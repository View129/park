package com.issc.second.service;

import com.issc.second.dao.BlackListDao;
import com.issc.second.entity.BlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlackListService {
    @Autowired
    BlackListDao blackListDao;

    /**
     * 根据车牌查询是否是黑名单
     * @param cardId
     * @return  是黑名单车辆 返回 1  不是 返回 0
     */
    public String find(String cardId){
        BlackList blackList = blackListDao.findByCardId(cardId);
        if(blackList!=null){
            return "1";
        }else {
            return "0";
        }
    }

    /**
     * 加入黑名单
     * @param cardId
     * @param description
     * @return
     */
    public String add(String cardId,String description){
        BlackList blackList= new BlackList();
        blackList.setCardId(cardId);
        blackList.setDescription(description);
        BlackList bk = blackListDao.save(blackList);
        if (bk!=null){
            return "成功";
        }else{
            return "失败";
        }
    }

    /**
     * 删除黑名单
     * @param id
     * @return
     */
    public String del(Long id){
        try {
            blackListDao.delete(id);
        }catch (Exception e){
            return "失败";
        }
            return "成功";

    }
}
