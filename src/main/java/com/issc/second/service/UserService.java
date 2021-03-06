package com.issc.second.service;

import com.issc.second.dao.UserDao;
import com.issc.second.dto.Msg;
import com.issc.second.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    //查询所有用户信息
    public Page<User> userList(String userName,String rank,String page, String pageSize,String sortt,String order){
        Sort sort = new Sort(order.equals("asc")?Sort.Direction.ASC:Sort.Direction.DESC, sortt);
        Pageable pageable = new PageRequest(Integer.valueOf(page)-1,Integer.valueOf(pageSize),sort);

        Page<User> list = userDao.findAll(Specifications.where(getWhere(userName,rank)),pageable);
        return list;
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
    public Msg deleteUser(List<User> list){
        Msg msg = null;
        try{
            userDao.delete(list);
        }catch(Exception e){
            msg = Msg.setError();
            return msg;
        }
        msg = Msg.setSuccess();
        return msg;
    }


    //组合查询
    private Specification<User> getWhere(String userName,String rank){
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();

                if(userName!=null&&userName!=""){

                    Path path = root.get("userName");
                    list.add(criteriaBuilder.equal(path,userName));
                }
                if(rank!=null&&rank!=""){
                    Path path = root.get("rank");
                    list.add(criteriaBuilder.equal(path,rank));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
    }
}
