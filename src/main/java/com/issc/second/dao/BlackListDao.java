package com.issc.second.dao;

import com.issc.second.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListDao extends JpaRepository<BlackList,Long> {

    //根据车牌查询黑名单
    BlackList findByCardId(String CardId);
}
