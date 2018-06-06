package com.siniswift.flightMonitor.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.entity.FlightEntity;
import com.siniswift.flightMonitor.entity.FlightRestrictionEntity;

public interface FlightRestrictionDao {
    int deleteByPrimaryKey(String restrictionId);

    int insert(FlightRestrictionEntity record);

    int insertSelective(FlightRestrictionEntity record);

    FlightRestrictionEntity selectByPrimaryKey(String restrictionId);

    int updateByPrimaryKeySelective(FlightRestrictionEntity record);

    int updateByPrimaryKeyWithBLOBs(FlightRestrictionEntity record);

    int updateByPrimaryKey(FlightRestrictionEntity record);
    
    FlightRestrictionEntity getByFlightIdandType(@Param("flightId") String flightId,@Param("type") String type);

	ArrayList<FlightRestrictionEntity> getFlightRestriction(@Param("flightId")String flightId);

	ArrayList<FlightRestrictionEntity> ListByFlightArrray(@Param("flightIdList")ArrayList<FlightEntity> flightIdList,@Param("dictCodeList")ArrayList<String> dictCodeList);
    
}