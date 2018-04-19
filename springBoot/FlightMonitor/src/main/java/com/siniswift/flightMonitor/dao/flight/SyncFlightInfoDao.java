package com.siniswift.flightMonitor.dao.flight;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.entity.flight.SyncFlightInfoEntity;
import com.siniswift.flightMonitor.pojo.SimpleFlightInfo;

public interface SyncFlightInfoDao {
    int deleteByPrimaryKey(String flightId);

    int insert(SyncFlightInfoEntity record);

    int insertSelective(SyncFlightInfoEntity record);

    SyncFlightInfoEntity selectByPrimaryKey(String flightId);

    int updateByPrimaryKeySelective(SyncFlightInfoEntity record);

    int updateByPrimaryKey(SyncFlightInfoEntity record);
    
    int saveOrUpdateByFlightId(SyncFlightInfoEntity record);

	ArrayList<SimpleFlightInfo> ListFlightByTime(@Param("start")String start, @Param("end")String end);
    
}