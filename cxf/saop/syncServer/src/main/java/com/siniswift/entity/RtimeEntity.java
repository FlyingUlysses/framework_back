package com.siniswift.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:  RtimeEntity   
 * @author: wangyong 
 * @date:   2018年3月29日
 * @Description:rtime实体类
 */
public class RtimeEntity implements Serializable{
	
	private static final long serialVersionUID = -7567982338951541227L;

	private String rtimeId;

    private String codeRestriction;

    private String txtNotamInfo;

    private String txtLastmodify;

    private Date dateLastmodify;

    private String codeStatus;

    private String txtDesigSegment;

    private String txtDesigRtime;

    private String txtRemark;
    
    private Integer valDeleted;

	public Integer getValDeleted() {
		return valDeleted;
	}

	public void setValDeleted(Integer valDeleted) {
		this.valDeleted = valDeleted;
	}

	public String getRtimeId() {
        return rtimeId;
    }

    public void setRtimeId(String rtimeId) {
        this.rtimeId = rtimeId == null ? null : rtimeId.trim();
    }

    public String getCodeRestriction() {
        return codeRestriction;
    }

    public void setCodeRestriction(String codeRestriction) {
        this.codeRestriction = codeRestriction == null ? null : codeRestriction.trim();
    }

    public String getTxtNotamInfo() {
        return txtNotamInfo;
    }

    public void setTxtNotamInfo(String txtNotamInfo) {
        this.txtNotamInfo = txtNotamInfo == null ? null : txtNotamInfo.trim();
    }

    public String getTxtLastmodify() {
        return txtLastmodify;
    }

    public void setTxtLastmodify(String txtLastmodify) {
        this.txtLastmodify = txtLastmodify == null ? null : txtLastmodify.trim();
    }

    public Date getDateLastmodify() {
        return dateLastmodify;
    }

    public void setDateLastmodify(Date dateLastmodify) {
        this.dateLastmodify = dateLastmodify;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus == null ? null : codeStatus.trim();
    }

    public String getTxtDesigSegment() {
        return txtDesigSegment;
    }

    public void setTxtDesigSegment(String txtDesigSegment) {
        this.txtDesigSegment = txtDesigSegment == null ? null : txtDesigSegment.trim();
    }

    public String getTxtDesigRtime() {
        return txtDesigRtime;
    }

    public void setTxtDesigRtime(String txtDesigRtime) {
        this.txtDesigRtime = txtDesigRtime == null ? null : txtDesigRtime.trim();
    }

    public String getTxtRemark() {
        return txtRemark;
    }

    public void setTxtRemark(String txtRemark) {
        this.txtRemark = txtRemark == null ? null : txtRemark.trim();
    }
}