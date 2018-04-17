package com.siniswift.flightMonitor.dao.flight;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.entity.flight.FlightInfoEntity;
import com.siniswift.flightMonitor.pojo.SimpleAirportInfo;

public interface FlightInfoDao {
    int deleteByPrimaryKey(String flightInfoId);

    int insert(FlightInfoEntity record);

    int insertSelective(FlightInfoEntity record);

    FlightInfoEntity selectByPrimaryKey(String flightInfoId);

    int updateByPrimaryKeySelective(FlightInfoEntity record);

    int updateByPrimaryKey(FlightInfoEntity record);
    
    ArrayList<SimpleAirportInfo> getAllSimpleAirportInfo();

    ArrayList<SimpleAirportInfo> getFlightListByAirPort(@Param("code")String code);
    
}