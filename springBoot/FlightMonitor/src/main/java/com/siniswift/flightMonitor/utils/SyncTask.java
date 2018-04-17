package com.siniswift.flightMonitor.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.siniswift.flightMonitor.service.SyncService;

/**
 * @ClassName:  SyncTask   
 * @author: wangyong 
 * @date:   2018年4月16日
 * @Description:定时任务 30min刷新一次
 */
@Component
public class SyncTask {
	
	@Resource
	private SyncService service;
	
	 @Scheduled(fixedDelay = Constants.GET_FIGHT_TIME)
	 public void dateTask() {
		 SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		 Date now = new Date();
		 Date end = new Date( new Date().getTime() + 6*3600*1000);
		 try {
//			service.getFlight(format.format(now), format.format(end));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 System.out.println("同步数据完成:"+format.format(now)+"-----"+format.format(end));
	 }
	
}
