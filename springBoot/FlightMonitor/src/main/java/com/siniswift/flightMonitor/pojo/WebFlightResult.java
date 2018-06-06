package com.siniswift.flightMonitor.pojo;

import java.util.ArrayList;

import com.alibaba.fastjson.annotation.JSONField;
import com.siniswift.flightMonitor.entity.FlightEntity;

/**
 * @ClassName:  WebFlightResult   
 * @author: wangyong 
 * @date:   2018年5月25日
 * @Description:接收webservice返回航班结果类
 */
public class WebFlightResult {
	
	private ArrayList<FlightEntity> body;
	
	@JSONField(name="Body")
	public ArrayList<FlightEntity> getBody() {
		return body;
	}

	public void setBody(ArrayList<FlightEntity> body) {
		this.body = body;
	}
	
}
