package com.siniswift.flightMonitor.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.entity.AirportEntity;

public interface AirportDao {
    int deleteByPrimaryKey(String airportId);
    
    int insert(AirportEntity record);

    int insertSelective(AirportEntity record);

    AirportEntity selectByPrimaryKey(String airportId);

    int updateByPrimaryKeySelective(AirportEntity record);

    int updateByPrimaryKey(AirportEntity record);

	ArrayList<AirportEntity> listAllAirport();

	ArrayList<AirportEntity> showSeat(@Param("seatId")String seatId);
	
	String strListairport(@Param("seatId")String seatId);
	
}