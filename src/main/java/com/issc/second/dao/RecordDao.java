package com.issc.second.dao;

import com.issc.second.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordDao extends JpaRepository<Record,Long>, JpaSpecificationExecutor<Record> {
}
