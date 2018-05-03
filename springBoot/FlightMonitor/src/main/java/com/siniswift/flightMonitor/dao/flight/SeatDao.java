package com.siniswift.flightMonitor.dao.flight;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.entity.SeatEntity;

public interface SeatDao {
    int deleteByPrimaryKey(String seatId);

    int insert(SeatEntity record);

    int insertSelective(SeatEntity record);

    SeatEntity selectByPrimaryKey(String seatId);

    int updateByPrimaryKeySelective(SeatEntity record);

    int updateByPrimaryKey(SeatEntity record);

	ArrayList<SeatEntity> listAllSeat();

	int haveSeatByName(@Param("name") String name);
	
}