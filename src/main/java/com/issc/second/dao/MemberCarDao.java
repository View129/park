package com.issc.second.dao;

import com.issc.second.entity.MemberCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCarDao extends JpaRepository<MemberCar,Long>{

}
