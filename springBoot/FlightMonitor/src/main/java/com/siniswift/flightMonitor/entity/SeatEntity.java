	package com.siniswift.flightMonitor.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * SEAT
 * @author 
 */
public class SeatEntity implements Serializable {
    private String seatId;

    private String seatName;
    
    private Integer state;
    
    private Date createTime;
    
    private static final long serialVersionUID = 1L;

    
    
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
}