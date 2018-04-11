package com.issc.second.service;

import com.issc.second.dao.UserDao;
import com.issc.second.entity.Msg;
import com.issc.second.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    //查询所有用户信息
    public Msg<User> userList(){
        List<User>list = userDao.findAll();
        Msg msg = null;
        if(list.size()>0){
            msg = Msg.setSuccess();
            msg.add("list",list);
        }else{
            msg =Msg.setError();
        }
        return msg;
    }

    //登录验证
    public Msg<User> login(String userName,String password){
        User user = userDao.findByUserNameAndPassword(userName,password);
        Msg msg = null;
        if(user!=null){
            msg = Msg.setSuccess();
        }else{
            msg = Msg.setError();
        }
        return msg;
    }

    //添加或修改用户信息
    public Msg<User> modifyUser(User user){
        User u = userDao.save(user);
        Msg msg = null;
        if(u!=null){
            msg = Msg.setSuccess();
        }else{
            msg = Msg.setError();
        }
        return msg;
    }

    //查询某用户是否存在
    public User findByUsername(String userName){
        return userDao.findByUserName(userName);
    }

    //根据id删除用户
    public Msg deleteUser(Long id){
        Msg msg = null;
        try{
            userDao.delete(id);
        }catch(Exception e){
            msg = Msg.setError();
            return msg;
        }
        msg = Msg.setSuccess();
        return msg;
    }

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