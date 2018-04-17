package com.siniswift.flightMonitor.pojo;

import java.util.Date;

public class SimpleFlightInfo {
	private String flightId;
	
	private String flightNumber;
	 
	private String dep4code;
	
    private String arr4code;	 

    private Date std;
    
    private Date sta;
    
    private String stdStr;
    
    private String staStr;

	private String departureAirportName;
    
    private String arrivalAirportName;
    
    private Boolean flag = false;
    
    public String getStdStr() {
    	return stdStr;
    }
    
    public void setStdStr(String stdStr) {
    	this.stdStr = stdStr;
    }
    
	public String getStaStr() {
		return staStr;
	}

	public void setStaStr(String staStr) {
		this.staStr = staStr;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDep4code() {
		return dep4code;
	}

	public void setDep4code(String dep4code) {
		this.dep4code = dep4code;
	}

	public String getArr4code() {
		return arr4code;
	}

	public void setArr4code(String arr4code) {
		this.arr4code = arr4code;
	}

	public Date getStd() {
		return std;
	}

	public void setStd(Date std) {
		this.std = std;
	}

	public Date getSta() {
		return sta;
	}

	public void setSta(Date sta) {
		this.sta = sta;
	}

	public String getDepartureAirportName() {
		return departureAirportName;
	}

	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
    
}
