package com.issc.second.service;

import com.issc.second.dao.MemberDao;
import com.issc.second.entity.Member;
import com.issc.second.entity.Msg;
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

/**
 * 月租户
 */
@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    /**
     * 新增月住户
     * @return
     */
    public Msg add(Member member){
        Member mb = memberDao.save(member);
        if(mb!=null){
            return Msg.setSuccess();
        }else{
            return Msg.setError();
        }
    }

    /**
     * 删除月租户
     * @param id
     * @return
     */
    public Msg del(Long id){
        try {
            memberDao.delete(id);
        }catch (Exception e){
            return Msg.setError();
        }
        return Msg.setSuccess();

    }

    /**
     * 查询所有月租户
     * @return
     */
    public Page<Member> list(Member member,String page, String pageSize,String sortt,String order){
        Sort sort = new Sort(order.equals("asc")?Sort.Direction.ASC:Sort.Direction.DESC, sortt);
        Pageable pageable = new PageRequest(Integer.valueOf(page)-1,Integer.valueOf(pageSize),sort);

        Page<Member> li =  memberDao.findAll(Specifications.where(getWhere(member)),pageable);
        return li;
    }



    private Specification<Member> getWhere(Member member){
        return new Specification<Member>() {
            @Override
            public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();


                if(member.getMemberName()!=null&&member.getMemberName()!=""){
                    Path path = root.get("memberName");
                    list.add(criteriaBuilder.equal(path,member.getMemberName()));
                }
                if(member.getTelephone()!=null&&member.getTelephone()!=""){
                    Path path = root.get("telephone");
                    list.add(criteriaBuilder.equal(path,member.getTelephone()));
                }



                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
    }


}
