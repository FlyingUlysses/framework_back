package com.siniswift.flightMonitor.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.entity.FlightEntity;

public interface FlightDao {
    int deleteByPrimaryKey(String flightId);

    int insert(FlightEntity record);

    int insertSelective(FlightEntity record);

    FlightEntity selectBaseByPrimaryKey(String flightId);
    
    FlightEntity selectClobByPrimaryKey(String flightId);

    int updateByPrimaryKeySelective(FlightEntity record);

    int updateByPrimaryKeyWithBLOBs(FlightEntity record);

    int updateByPrimaryKey(FlightEntity record);
    
    ArrayList<FlightEntity> listNotTackOffByTime(@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("haveClob") Integer haveClob);
    
    ArrayList<FlightEntity> listTackOffByTime(@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("haveClob") Integer haveClob);
    
    ArrayList<FlightEntity> listByTimeAndSeat(@Param("isStart") String isStart,@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("array") String[] array,
    		@Param("type")Integer type);
    
}