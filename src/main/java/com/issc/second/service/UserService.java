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

    //查询所有用户信息
    public List<User> userList(){
        return userDao.findAll();
    }

    //登录验证
    public User login(String userName,String password){
        return userDao.findByUserNameAndPassword(userName,password);
    }

    //添加用户信息,只要返回值不为空则添加成功
    public User modifyUser(User user){
        return userDao.save(user);
    }


//    //根据id修改密码
//    public int updatePassword(Long id,String password){
//        int count = userDao.updateUserPassword(id,password);
//        return count;
//    }
//
//    //根据id修改用户权限
//    public int updateRank(Long id,String rank){
//        int count = userDao.updateUserRank(id,rank);
//        return count;
//    }


}
