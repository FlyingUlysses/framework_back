package com.siniswift.flightMonitor.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.siniswift.flightMonitor.dao.flight.FlightInfoDao;
import com.siniswift.flightMonitor.dao.flight.SyncFlightInfoDao;
import com.siniswift.flightMonitor.dao.notam.ImportancNotamLogDao;
import com.siniswift.flightMonitor.pojo.AirportNotam;
import com.siniswift.flightMonitor.pojo.SimpleAirportInfo;
import com.siniswift.flightMonitor.pojo.SimpleFlightInfo;
import com.siniswift.flightMonitor.pojo.SimpleNotam;

/**
 * @ClassName:  FlightInfoService   
 * @author: wangyong 
 * @date:   2018年4月24日
 * @Description:航班相关服务层
 */
@Service
public class FlightInfoService {
	
	@Autowired
	private FlightInfoDao flightInfoDao2;
	@Autowired
	private ImportancNotamLogDao notamDao;
	@Autowired
	private SyncFlightInfoDao flightInfoDao;
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:首页磁贴展示
	 */
	public ArrayList<SimpleFlightInfo> ListFlightByTime(String type,String start,String end){
		ArrayList<SimpleFlightInfo> flightList = flightInfoDao.ListFlightByTime(start,end);
		ArrayList<SimpleNotam> notamList = notamDao.ListSimpleNotamByTime(start, end);
		ArrayList<SimpleFlightInfo> commonList = new ArrayList<SimpleFlightInfo>();
		ArrayList<SimpleFlightInfo> haveTroubleList = new ArrayList<SimpleFlightInfo>();
		boolean flag = false;
		SimpleDateFormat formart = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		for (SimpleFlightInfo flight : flightList) {
			flag = false;
			for (SimpleNotam notam : notamList) {
				if(flight.getDep4code().equals(notam.getAirport())) {
					if( (flight.getStd().getTime() > notam.getStart().getTime() && flight.getStd().getTime() < notam.getEnd().getTime())) {
						haveTroubleList.add(flight);
						flight.setFlag(true);
						flag = true;
						break;
					}
				}else if(flight.getDep4code().equals(notam.getAirport())) {
					if( flight.getSta().getTime() > notam.getStart().getTime() && flight.getSta().getTime() < notam.getEnd().getTime() ) {
						haveTroubleList.add(flight);
						flight.setFlag(true);
						flag = true;
						break;
					}
				}
			}
			if(!flag) 
				commonList.add(flight);
			flight.setStdStr(formart.format(flight.getStd()));
			flight.setStaStr(formart.format(flight.getSta()));
		}
		ArrayList<SimpleFlightInfo> res = new ArrayList<SimpleFlightInfo>();
		if(type.equals("all")) {
			res.addAll(haveTroubleList);
			res.addAll(commonList);
		}else if(type.equals("trouble")) {
			res=haveTroubleList;
		}
		return res;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:根据航班查询航班下所有通告
	 */
	public ArrayList<SimpleNotam> ListNotamByFlight(String start, String end, String startName,
			String endName) {
		ArrayList<SimpleNotam> notamList = notamDao.ListNotamByFlight(start,end);
		for (SimpleNotam notam : notamList) {
			if(notam.getAirport().equals(start))
				notam.setAirport_name(startName);
			if(notam.getAirport().equals(end))
				notam.setAirport_name(endName);
		}	
		return notamList;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:机场表格查询   //数据库结构已修改，暂时只维持展示
	 */
	@Deprecated
	public ArrayList<AirportNotam> getAirPortTable() {
		ArrayList<SimpleAirportInfo> infoList = flightInfoDao2.getAllSimpleAirportInfo();
		ArrayList<AirportNotam> result = new ArrayList<AirportNotam>();
		ArrayList<String> airportList = new ArrayList<String>();
		for (SimpleAirportInfo info : infoList) {
			if(airportList.indexOf(info.getArrivalAirport()) == -1) {
				airportList.add(info.getArrivalAirport());
				AirportNotam notam = new AirportNotam();
				notam.setAirport(info.getArrivalAirport());
				result.add(notam);
			}else if(airportList.indexOf(info.getDepartureAirport()) == -1) {
				airportList.add(info.getDepartureAirport());
				AirportNotam notam = new AirportNotam();
				notam.setAirport(info.getDepartureAirport());
				result.add(notam);
			}
		}
		ArrayList<AirportNotam> subNotamList = notamDao.getAirportNotamBySomeAirport(airportList);
		ArrayList<AirportNotam> subs = null;
		for (AirportNotam res : result) {
			subs = new ArrayList<>();
			for (AirportNotam sub : subNotamList) {
				if(sub.getAirport().equals(res.getAirport())) {
					subs.add(sub);
				}
			}
			res.setNotam_list(subs);
		}
		return sortForHaveThroble(result);
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:机场根据通告排序  //受限于上一个方法已废弃
	 */
	@Deprecated
	private ArrayList<AirportNotam> sortForHaveThroble(ArrayList<AirportNotam> list) {
		ArrayList<AirportNotam> haveThrowble = new ArrayList<AirportNotam>();
		ArrayList<AirportNotam> common = new ArrayList<AirportNotam>();
		for (AirportNotam airport : list) {
			if(airport.getNotam_list().size() >0) {
				haveThrowble.add(airport);
			}else {
				common.add(airport);
			}
		}
		ArrayList<AirportNotam> res = new ArrayList<>();
		res.addAll(haveThrowble);
		res.addAll(common);
		return res;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:根据通告查询所有受影响航班  //数据库结构已修改，暂时只维持展示
	 */
	@Deprecated
	public ArrayList<SimpleAirportInfo> getFlightListByAirPort(String code) {
		 return flightInfoDao2.getFlightListByAirPort(code);
	}
	
}
