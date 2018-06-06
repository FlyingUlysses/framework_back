package com.siniswift.flightMonitor.entity;

import java.io.Serializable;

/**
 * EXPORT_RECORD
 * @author 
 */
public class ExportRecordEntity implements Serializable {
    private String recordId;

    private String seatId;

    private String flightId;

    private Integer isLimited;

    private static final long serialVersionUID = 1L;
    
    public Integer getIsLimited() {
		return isLimited;
	}

	public void setIsLimited(Integer isLimited) {
		this.isLimited = isLimited;
	}


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }


}