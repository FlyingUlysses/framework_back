package com.siniswift.flightMonitor.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:  SimpleNotam   
 * @author: wangyong 
 * @date:   2018年5月2日
 * @Description:用于解析notam的通告数据
 */
public class SimpleNotam implements Serializable {
	private static final long serialVersionUID = 1L;

	private String restrictionId;
    
    private String importancId;
    
    private String itemId;

    private String type;

    private Short state;

    private Date startTime;

    private Date endTime;

    private String airport4code;

    private String content;
    
	public String getImportancId() {
		return importancId;
	}

	public void setImportancId(String importancId) {
		this.importancId = importancId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getRestrictionId() {
        return restrictionId;
    }

    public void setRestrictionId(String restrictionId) {
        this.restrictionId = restrictionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAirport4code() {
        return airport4code;
    }

    public void setAirport4code(String airport4code) {
        this.airport4code = airport4code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}