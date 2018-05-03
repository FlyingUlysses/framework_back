package com.siniswift.flightMonitor.dao.notam;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import com.siniswift.flightMonitor.pojo.SimpleNotam;

public interface NotamDao {
	ArrayList<SimpleNotam> ListNotamByTime(@Param("startTime")Date startTime,@Param("endTime") Date endTime);

	ArrayList<SimpleNotam> ListNotamByFlight(String flightId);
	
}