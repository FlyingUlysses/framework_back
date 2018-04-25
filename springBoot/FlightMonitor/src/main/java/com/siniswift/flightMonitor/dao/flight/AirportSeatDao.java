package com.siniswift.flightMonitor.dao.flight;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.entity.flight.AirportSeatEntity;

public interface AirportSeatDao {
    int deleteByPrimaryKey(String airportSeatId);

    int insert(AirportSeatEntity record);

    int insertSelective(AirportSeatEntity record);

    AirportSeatEntity selectByPrimaryKey(String airportSeatId);

    int updateByPrimaryKeySelective(AirportSeatEntity record);

    int updateByPrimaryKey(AirportSeatEntity record);
    
    void deleteBySeat(@Param("seatId")String seatId);

	void saveList(@Param("seatId")String seatId,@Param("list") String[] list);

}