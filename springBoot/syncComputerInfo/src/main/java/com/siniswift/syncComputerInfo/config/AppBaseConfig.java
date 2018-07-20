package com.siniswift.syncComputerInfo.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;

/**
 * @ClassName:  AppBaseConfig   
 * @author: WangYong 
 * @date:   2018年7月16日
 * @Description:app基础配置信息控制类
 */
@Configuration
@PropertySource(value="classpath:appBaseConfig.properties")
public class AppBaseConfig {
	
	//获取信息初始时间
	@Value("${appBaseConfig.timeGetInfoInit}")
	public long timeGetInfoInit;
	
	//获取信息间隔时间
	@Value("${appBaseConfig.timeGetInfoInterval}")
	public long timeGetInfoInterval ;
	
	//监测磁盘的网址
	@Value("${appBaseConfig.diskName}")
	public String diskName;
	
	//同步请求的网址
	@Value("${appBaseConfig.syncUrl}")
	public String syncUrl;
	
	//同步id
	@Value("${appBaseConfig.syncId}")
	public Long syncId;
	
	private static PropertiesConfiguration propConfig;
	
	public static void init() {
	    try {
	      propConfig = new PropertiesConfiguration(ResourceUtils.getURL("classpath:").getPath()+"/appBaseConfig.properties");
	      propConfig.setReloadingStrategy(new FileChangedReloadingStrategy());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	 }
	 
	public void setId(Long id) throws ConfigurationException {
	   syncId = id;
	   propConfig.setProperty("appBaseConfig.syncId", id+"");
	   propConfig.save();
	}
	
}
