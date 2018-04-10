package com.issc.second.dao;

import com.issc.second.entity.Entrance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntranceDao extends JpaRepository<Entrance,Long>{

}
