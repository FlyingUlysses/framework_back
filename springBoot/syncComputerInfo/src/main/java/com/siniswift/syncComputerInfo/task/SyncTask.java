package com.siniswift.syncComputerInfo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import com.siniswift.syncComputerInfo.config.AppBaseConfig;
import com.siniswift.syncComputerInfo.service.GetComputerInfoService;

/**
 * @ClassName:  SyncTask   
 * @author: WangYong 
 * @date:   2018年7月16日
 * @Description:定时任务类
 */
@Component
public class SyncTask implements SchedulingConfigurer{
	
	@Autowired
	private AppBaseConfig baseConfig;
	
	@Autowired
	private GetComputerInfoService GetComputerInfoService;
	
	/**
	 * @author: WangYong 
	 * @date:   2018年7月16日
	 * @Description:定时任务入口
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		syncComputerInfo(taskRegistrar);
	}
	
	/**
	 * @author: WangYong 
	 * @date:   2018年7月16日
	 * @Description:获取服务器信息任务
	 */
	private void syncComputerInfo(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addFixedDelayTask(new IntervalTask(new Runnable() {
			@Override
			public void run() {
				GetComputerInfoService.syncComputerInfo();
			}
		}, baseConfig.timeGetInfoInterval,baseConfig.timeGetInfoInit));
	}
	
}
