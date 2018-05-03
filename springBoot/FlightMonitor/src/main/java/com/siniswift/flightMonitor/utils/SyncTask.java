package com.siniswift.flightMonitor.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.siniswift.flightMonitor.service.FilghtService;

/**
 * @ClassName:  SyncTask   
 * @author: wangyong 
 * @date:   2018年4月16日
 * @Description:定时任务类， 用于定时更新数据
 */
@Component
public class SyncTask {
	
	@Resource
	private FilghtService flight;
	
	 @Scheduled(fixedDelay = Constants.TIME_GET_FIGHT)
	 public void dateTask() {
		 SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		 Date now = new Date();
		 Date end = new Date( new Date().getTime() + Constants.TIME_GET_FIGHT);
		 try {
//			flight.getFlight(format.format(now), format.format(end));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 System.out.println("同步数据完成:"+format.format(now)+"-----"+format.format(end));
	 }
	
}
