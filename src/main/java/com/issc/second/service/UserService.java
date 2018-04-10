package com.issc.second.service;

import com.issc.second.dao.UserDao;
import com.issc.second.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    //查询所有信息
    public List<User> userList(){
        return userDao.findAll();
    }

    //登录验证
    public User login(String userName,String password){
        return userDao.findByUserNameAndPassword(userName,password);
    }

    //修改密码
    public void updatePassword(Long id,String password){
        userDao.updateUserPassword(id,password);
    }

    //修改用户权限
    public void updateRank(Long id,String rank){
        userDao.updateUserRank(id,rank);
    }
}
