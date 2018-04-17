package com.siniswift.flightMonitor.entity.flight;

import java.io.Serializable;
import java.util.Date;

/**
 * SYNC_FLIGHT_INFO
 * @author 
 */
public class SyncFlightInfoEntity implements Serializable {
    private String flightId;

    private String flightNumber;

    private Date std;

    private Date sta;

    private String dep4code;

    private String arr4code;
    
    private Integer count;
    
    private String depCityName;
    
    private String arrCityName;
    
    private static final long serialVersionUID = 1L;

    
    public Integer getCount() {
		return count;
	}

	public String getDepCityName() {
		return depCityName;
	}

	public void setDepCityName(String depCityName) {
		this.depCityName = depCityName;
	}

	public String getArrCityName() {
		return arrCityName;
	}

	public void setArrCityName(String arrCityName) {
		this.arrCityName = arrCityName;
	}

	public void setCount(Integer count) {
		this.count = count;
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
}