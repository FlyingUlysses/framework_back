package com.siniswift.flightMonitor.pojo;
/**
 * @ClassName:  SimpleRoute   
 * @author: wangyong 
 * @date:   2018年4月17日
 * @Description:航线数据接收类
 */
public class SimpleRoute {
	
	private String id;
	
	private String code;
	
	private String startAirport;
	
	private String endAirport;
	
	private String cfp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStartAirport() {
		return startAirport;
	}

	public void setStartAirport(String startAirport) {
		this.startAirport = startAirport;
	}

	public String getEndAirport() {
		return endAirport;
	}

	public void setEndAirport(String endAirport) {
		this.endAirport = endAirport;
	}

	public String getCfp() {
		return cfp;
	}

	public void setCfp(String cfp) {
		this.cfp = cfp;
	}
	
}
