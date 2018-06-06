package com.siniswift.flightMonitor.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;

import com.siniswift.flightMonitor.utils.SyncTask;

/**
 * @ClassName:  AppBaseConfig   
 * @author: wangyong 
 * @date:   2018年5月29日
 * @Description:基础配置信息类
 */
@Configuration
@PropertySource(value="classpath:appBaseConfig.properties")
public class AppBaseConfig {
	
	/**
	 * 获取航班任务间隔时间-毫秒
	 */
	@Value("${appBaseConfig.timeGetFlightInterval}")
	public  long  timeGetFlightInterval ;
	
	/**
	 * 页面获取航班时间的间隔
	 */
	@Value("${appBaseConfig.pageTimeGetFlight}")
	public  long  pageTimeGetFlight;
	
	/**
	 * 分析航行中航班任务间隔-毫秒
	 */
	@Value("${appBaseConfig.timeStartedFlightInterval}")
	public  long timeStartedFlightInterval;
	
	/**
	 *首次启动分析航行中航班任务延迟-毫秒
	 */
	@Value("${appBaseConfig.timeStartedFlightInit}")
	public  long timeStartedFlightInit;
	
	/**
	 * 分析未起飞航班任务间隔-毫秒
	 */
	@Value("${appBaseConfig.timeWaitFlightInterval}")
	public  long timeWaitFlightInterval;	
	
	/**
	 *首次启动分析未起飞任务延迟-毫秒 
	 */
	@Value("${appBaseConfig.timeWaitFlightInit}")
	public  long timeWaitFlightInit ;
	
	private static PropertiesConfiguration propConfig;
	
	public static void init() {
	    try {
	      propConfig = new PropertiesConfiguration(ResourceUtils.getURL("classpath:").getPath()+"/appBaseConfig.properties");
	      propConfig.setReloadingStrategy(new FileChangedReloadingStrategy());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	 }
	  
	public Object getValue(String key) {
		return propConfig.getProperty(key);
	}
	  
	public void setProperty(String key, String value) throws ConfigurationException {
	   propConfig.setProperty(key, value);
	   propConfig.save();
	}
	
	public void saveAll(String timeGetFlightInterval,String pageTimeGetFlight,String timeStartedFlightInterval,String timeStartedFlightInit,String timeWaitFlightInterval,
			String timeWaitFlightInit) throws Exception {
		this.timeGetFlightInterval = SyncTask.stringToTime(timeGetFlightInterval);
		this.pageTimeGetFlight = SyncTask.stringToTime(pageTimeGetFlight);
		this.timeStartedFlightInterval = SyncTask.stringToTime(timeStartedFlightInterval);
		this.timeStartedFlightInit = SyncTask.stringToTime(timeStartedFlightInit);
		this.timeWaitFlightInterval = SyncTask.stringToTime(timeWaitFlightInterval);
		this.timeWaitFlightInit = SyncTask.stringToTime(timeWaitFlightInit);
		propConfig.setProperty("appBaseConfig.timeGetFlightInterval", this.timeGetFlightInterval+"");
		propConfig.setProperty("appBaseConfig.pageTimeGetFlight", this.pageTimeGetFlight+"");
		propConfig.setProperty("appBaseConfig.timeStartedFlightInterval", this.timeStartedFlightInterval+"");
		propConfig.setProperty("appBaseConfig.timeStartedFlightInit", this.timeStartedFlightInit+"");
		propConfig.setProperty("appBaseConfig.timeWaitFlightInterval", this.timeWaitFlightInterval+"");
		propConfig.setProperty("appBaseConfig.timeWaitFlightInit", this.timeWaitFlightInit+"");
		propConfig.save();
	}
}
