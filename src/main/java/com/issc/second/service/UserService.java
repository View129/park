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
}
