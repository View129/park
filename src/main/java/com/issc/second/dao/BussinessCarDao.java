package com.issc.second.dao;

import com.issc.second.entity.BussinessCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BussinessCarDao extends JpaRepository<BussinessCar,Long>{

}
