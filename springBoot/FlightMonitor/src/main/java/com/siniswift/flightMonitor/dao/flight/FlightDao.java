package com.siniswift.flightMonitor.dao.flight;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.entity.FlightEntity;

public interface FlightDao {
    int deleteByPrimaryKey(String flightId);

    int insert(FlightEntity record);

    int insertSelective(FlightEntity record);

    FlightEntity selectByPrimaryKey(String flightId);

    int updateByPrimaryKeySelective(FlightEntity record);

    int updateByPrimaryKeyWithBLOBs(FlightEntity record);

    int updateByPrimaryKey(FlightEntity record);
    
    ArrayList<FlightEntity> listNotTackOffByTime(@Param("startTime") Date startTime,@Param("endTime") Date endTime);
    
    ArrayList<FlightEntity> listByTimeAndSeat(@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("array") String[] array);
    
    ArrayList<FlightEntity> listErrorByTimeAndSeat(@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("array") String[] array);
    
}