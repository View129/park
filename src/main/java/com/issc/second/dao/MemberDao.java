package com.issc.second.dao;

import com.issc.second.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<Member,Long>, JpaSpecificationExecutor<Member> {

}
