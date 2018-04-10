package com.issc.second.dao;

import com.issc.second.entity.Exitus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExitDao extends JpaRepository<Exitus,Long>{
}
