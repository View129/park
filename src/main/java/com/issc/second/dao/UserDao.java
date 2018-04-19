package com.issc.second.dao;

import com.issc.second.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends JpaRepository<User,Long>{

    //登录验证
    User findByUserNameAndPassword(String userName,String password);

    //查询某用户是否存在
    User findByUserName(String userName);

}
