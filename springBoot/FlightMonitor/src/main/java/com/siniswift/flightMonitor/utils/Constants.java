package com.siniswift.flightMonitor.utils;

/**
 * @ClassName:  Constants   
 * @author: wangyong 
 * @date:   2018年4月17日
 * @Description:存储该程序内所有常量
 */
public class Constants {
	
	/**
	 * 系统通过webservice获取航班数据的固定时长
	 */
	public static final long TIME_GET_FIGHT =  (6*3600*1000);				
	
	/**
	 * 获取航班数据的webservice路径
	 */
	public static final String URL_GET_FLIGHT =  "http://efb.airchina.com.cn/flightMonitor/DataServiceEx.asmx/GetFlightData";
	
	/**
	 * 航班状态码：受限
	 */
	public static final int FLIGHT_STATE_ERROR =2;
	
	/**
	 * 航班状态码：正常
	 */
	public static final int FLIGHT_STATE_NORMAL =1;
	
	/**
	 * 航班状态码：取消
	 */
	public static final int FLIGHT_STATE_DEL =0;
	
	
}
