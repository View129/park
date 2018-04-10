package com.issc.second.dao;

import com.issc.second.entity.CarSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarSeatDao extends JpaRepository<CarSeat,Long> {
}
