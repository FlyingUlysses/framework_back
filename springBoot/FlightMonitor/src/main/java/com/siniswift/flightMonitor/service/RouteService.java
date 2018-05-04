package com.siniswift.flightMonitor.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.siniswift.flightMonitor.dao.aips.RouteDao;
import com.siniswift.flightMonitor.entity.FlightEntity;
import com.siniswift.flightMonitor.pojo.RestrictionInfo;
import com.siniswift.flightMonitor.pojo.SimpleRoute;

@Service
public class RouteService {
	
	@Autowired
	private RouteDao routeDao;
	
	/**
	 * @author: 获取route数据 
	 * @return 
	 * @date:   2018年4月17日
	 * @Description:获取航线数据，并通过webservice判断是否可行，分析数据后存储
	 */
	public ArrayList<FlightEntity> getRoute(ArrayList<FlightEntity> flightList ) {
		String user = routeDao.getActiveUser();
		if(user != null) {
			RestrictionInfo info = null;
			for (FlightEntity flight : flightList) {
				if(flight.getRestrictionResult() != null && flight.getRestrictionResult().trim().length() >0) {
					info = JSON.parseObject(flight.getRestrictionResult(), RestrictionInfo.class);
				}else {
					info = new RestrictionInfo();
				}
				ArrayList<SimpleRoute> routeList = routeDao.getRouteListByAirport(user, flight.getDep4code(), flight.getArr4code());
				for (SimpleRoute route : routeList) {
					//执行route查询返回一个route结果，此处暂时直接返回随机返回一个结果
					if(randomRes()) {
						route.setState(true);
						flight.setState(2);
					}else {
						route.setState(false);
					}
				}
				info.setRouteList(routeList);
				flight.setRestrictionResult(JSON.toJSONString(info));
			}
		}
		return flightList;
	}
	
	private boolean randomRes() {
		long time = new Date().getTime();
		if(time % 5 == 0)
			return true;
		else
			return false;
	}
	
}
