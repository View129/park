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

    User findByUserNameAndPassword(String userName,String password);

    //修改密码
    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.password = :password WHERE id=:id")
    void updateUserPassword(@Param("id")Long id, @Param("password") String password);

    //修改用户权限
    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.rank = :rank WHERE id=:id")
    void updateUserRank(@Param("id")Long id, @Param("rank") String rank);


}
