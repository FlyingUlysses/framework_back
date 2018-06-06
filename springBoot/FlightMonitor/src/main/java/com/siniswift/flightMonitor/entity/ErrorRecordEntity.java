package com.siniswift.flightMonitor.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ERROR_RECORD
 * @author 
 */
public class ErrorRecordEntity implements Serializable {
    private String errorId;

    private String remark;

    private String content;

    private Date createTime;

    private String type;

    private static final long serialVersionUID = 1L;

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}