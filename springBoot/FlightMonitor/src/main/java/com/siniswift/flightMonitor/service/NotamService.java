package com.siniswift.flightMonitor.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.siniswift.flightMonitor.dao.notam.NotamDao;
import com.siniswift.flightMonitor.entity.FlightEntity;
import com.siniswift.flightMonitor.pojo.RestrictionInfo;
import com.siniswift.flightMonitor.pojo.SimpleNotam;
import com.siniswift.flightMonitor.utils.Constants;

/**
 * @ClassName:  NotamService   
 * @author: wangyong 
 * @date:   2018年5月2日
 * @Description:notam应用层
 */
@Service
public class NotamService {
	
	@Autowired
	private NotamDao notamDao;
	
	/**
	 * @author: wangyong 
	 * @return 
	 * @date:   2018年4月25日
	 * @Description:根据开始、结束时间查询notam数据库获取数据
	 */
	public ArrayList<SimpleNotam> getNotam(Date startTime,Date endTime) {
		ArrayList<SimpleNotam> list =null;
		try {
			list = notamDao.ListNotamByTime(startTime,endTime);
		} catch (Exception e) {
			System.out.println("---------------获取notam数据出错-----------------------------");
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * @author: wangyong 
	 * @return 
	 * @return 
	 * @date:   2018年4月26日
	 * @Description:根据传入的notam数据和航班数据，执行逻辑判断航班是否受notam通告影响
	 */
	@Transactional(value="efbTransactionManager",timeout=36000,rollbackFor=Exception.class)
	public ArrayList<FlightEntity> analyzeFlightByNotam(ArrayList<FlightEntity> flightList,Date startTime,Date endTime,ArrayList<SimpleNotam> notamList) {
		try {
			RestrictionInfo res = null;
			ArrayList<SimpleNotam> subNotamList = null;
			for (FlightEntity flight : flightList) {
				flight.setState(Constants.FLIGHT_STATE_NORMAL);
				if(StringUtils.isEmpty(flight.getRestrictionResult())) {
					subNotamList =  new ArrayList<SimpleNotam>();
					res = new RestrictionInfo();
				}else {
					res = JSON.parseObject(flight.getRestrictionResult(), RestrictionInfo.class);
					subNotamList =res.getNotamList();
				}
				for (SimpleNotam notam : notamList) {
					if(flight.getDep4code().equals(notam.getAirport4code())) {
						if( flight.getStd().getTime() > notam.getStartTime().getTime() && flight.getStd().getTime() < notam.getEndTime().getTime() ) {
							flight.setState(Constants.FLIGHT_STATE_ERROR);
							if(!subNotamList.contains(notam))
								subNotamList.add(notam);
						}
					}else if(flight.getArr4code().equals(notam.getAirport4code())) {
						if(flight.getSta().getTime() > notam.getStartTime().getTime() && flight.getSta().getTime() < notam.getEndTime().getTime()) {
							flight.setState(Constants.FLIGHT_STATE_ERROR);
							if(!subNotamList.contains(notam))
								subNotamList.add(notam);
						}
					}
				}
				if(subNotamList.size() >0) {
					res.setNotamList(subNotamList);
					flight.setRestrictionResult(JSON.toJSONString(res));
				}
			}
		} catch (Exception e) {
			System.out.println("---------------分析notam数据出错-----------------------------");
			e.printStackTrace();
		}
		return flightList;
	}
	
}
