package com.siniswift.flightMonitor.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.siniswift.flightMonitor.entity.FlightEntity;
import com.siniswift.flightMonitor.service.FlightService;

/**
 * @ClassName:  SyncTask   
 * @author: wangyong 
 * @date:   2018年4月16日
 * @Description:定时任务类， 用于定时更新数据
 */
@Component
public class SyncTask {
	
	@Resource
	private FlightService flightService;
	
	 @Scheduled(fixedDelay = Constants.TIME_GET_FIGHT)
	 public void dateTask() {
		 SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		 Date now = new Date();
		 Date end = new Date( new Date().getTime() + Constants.TIME_GET_FIGHT);
		 try {
			flightService.getListFlightByWeb(now,end);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 System.out.println("同步数据完成:"+format.format(now)+"-----"+format.format(end));
	 }
	 
	@Scheduled(fixedDelay = Constants.TIME_NOT_TACK_OFF_FIGHT,initialDelay = 5000)
	public void notTackOffFlightTask() {
		 SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		 Date now = new Date();
		 Date end = new Date( new Date().getTime() + Constants.TIME_GET_FIGHT);
		 try {
			ArrayList<FlightEntity> flightList = flightService.ListNotTackOffByTime(now, end);
			flightService.annalyzeFlight(flightList, now, end);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 System.out.println("分析未起飞航班完成:"+format.format(now)+"-----"+format.format(end));
	}
	
	@Scheduled(fixedDelay = Constants.TIME_TACK_OFF_FIGHT,initialDelay = 5000)
	public void tackOffFlightTask() {
		 SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		 Date now = new Date();
		 Date end = new Date( new Date().getTime() + Constants.TIME_GET_FIGHT);
		 try {
			ArrayList<FlightEntity> flightList = flightService.ListTackOffByTime(now, end);
			flightService.annalyzeFlight(flightList, now, end);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 System.out.println("分析起飞航班完成:"+format.format(now)+"-----"+format.format(end));
	}
	
}
