package com.siniswift.flightMonitor.entity;

import java.io.Serializable;

/**
 * FLIGHT_RESTRICTION
 * @author 
 */
public class FlightRestrictionEntity implements Serializable {
    private String restrictionId;

    private String flightId;

    private String dictCode;

    private String content;
    

    private static final long serialVersionUID = 1L;

	public String getRestrictionId() {
        return restrictionId;
    }

    public void setRestrictionId(String restrictionId) {
        this.restrictionId = restrictionId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }
    
	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}