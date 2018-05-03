package com.siniswift.flightMonitor.entity;

import java.io.Serializable;

/**
 * AIRPORT
 * @author 
 */
public class AirportEntity implements Serializable {
    private String airportId;

    private String airport4code;

    private static final long serialVersionUID = 1L;
    
    private Integer flag;

    public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getAirport4code() {
        return airport4code;
    }

    public void setAirport4code(String airport4code) {
        this.airport4code = airport4code;
    }
}