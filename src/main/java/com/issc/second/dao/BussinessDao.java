package com.issc.second.dao;

import com.issc.second.entity.Bussiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BussinessDao extends JpaRepository<Bussiness,Long> {


}
