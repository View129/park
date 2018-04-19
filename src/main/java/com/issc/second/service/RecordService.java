package com.issc.second.service;

import com.issc.second.dao.RecordDao;
import com.issc.second.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    RecordDao recordDao;

    //查询所有车辆进出信息
    public Page<Record> recordList(Long carId,Date inTime,Date outTime,String page, String pageSize, String sortt, String order){
        Sort sort = new Sort(order.equals("asc")?Sort.Direction.ASC:Sort.Direction.DESC, sortt);
        Pageable pageable = new PageRequest(Integer.valueOf(page)-1,Integer.valueOf(pageSize),sort);
        Page<Record> list = recordDao.findAll(Specifications.where(getWhere(carId,inTime,outTime)),pageable);
        return list;
    }

   private Specification<Record> getWhere(Long carId,Date inTime,Date outTime){
        return new Specification<Record>() {
            @Override
            public Predicate toPredicate(Root<Record> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if(carId!=null){
                    Path path = root.get("carId");
                    list.add(criteriaBuilder.equal(path,carId));
                }
                if(inTime!=null){
                    Path path = root.get("inTime");
                    list.add(criteriaBuilder.greaterThanOrEqualTo(path, simpleDateFormat.format(inTime)));
                }
                if (outTime!= null) {
                    Path path = root.get("outTime");
                    list.add(criteriaBuilder.greaterThanOrEqualTo(path, simpleDateFormat.format(outTime)));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
   }


}
