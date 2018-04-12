package com.issc.second.dao;

import com.issc.second.entity.MemberOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberOrderDao extends JpaRepository<MemberOrder,Long>{


}
