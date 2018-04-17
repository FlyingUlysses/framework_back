package com.siniswift.flightMonitor.dao.notam;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.pojo.AirportNotam;
import com.siniswift.flightMonitor.pojo.SimpleNotam;

public interface ImportancNotamLogDao {
	ArrayList<AirportNotam> getAllAirportNotam();
	
	ArrayList<AirportNotam> getAirportNotamBySomeAirport(@Param("airportList") ArrayList<String> airportList);
	
	ArrayList<SimpleNotam> getSimpleNotamListByTime(@Param("start")String start,@Param("end") String end);
	
	ArrayList<SimpleNotam> getNotamListByFlight(@Param("start_airport_name")String start,@Param("end_airport_name") String end);
}