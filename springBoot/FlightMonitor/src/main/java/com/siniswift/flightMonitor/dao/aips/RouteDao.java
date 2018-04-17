package com.siniswift.flightMonitor.dao.aips;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.pojo.SimpleRoute;

public interface RouteDao {
	
	String getActiveUser();
	
	ArrayList<SimpleRoute> getRouteListByAirport(@Param("user") String user,@Param("start")String start,@Param("end")String end);
	
}
