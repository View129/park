package com.issc.second.dao;

import com.issc.second.entity.TemporaryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporaryOrderDao extends JpaRepository<TemporaryOrder,Long>{
}
