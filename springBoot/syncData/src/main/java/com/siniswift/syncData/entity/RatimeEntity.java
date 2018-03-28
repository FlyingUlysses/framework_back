package com.siniswift.syncData.entity;

import java.math.BigDecimal;
import java.util.Date;


public class RatimeEntity {
    private BigDecimal notamInfoId;

    private Date cachetimestamp;

    private Short historytag;

    private Double absoluteid;

    private String recordstatus;

    private Date lastmodified;

    private String lastusertomodify;

    private String companycode;

    private String airwayid;

    private String identifier;

    private String notamactivationind;

    private String controllingagency;

    private String restrictionreference;

    private byte[] ratime2;

    private byte[] remarks;

    public BigDecimal getNotamInfoId() {
        return notamInfoId;
    }

    public void setNotamInfoId(BigDecimal notamInfoId) {
        this.notamInfoId = notamInfoId;
    }

    public Date getCachetimestamp() {
        return cachetimestamp;
    }

    public void setCachetimestamp(Date cachetimestamp) {
        this.cachetimestamp = cachetimestamp;
    }

    public Short getHistorytag() {
        return historytag;
    }

    public void setHistorytag(Short historytag) {
        this.historytag = historytag;
    }

    public Double getAbsoluteid() {
        return absoluteid;
    }

    public void setAbsoluteid(Double absoluteid) {
        this.absoluteid = absoluteid;
    }

    public String getRecordstatus() {
        return recordstatus;
    }

    public void setRecordstatus(String recordstatus) {
        this.recordstatus = recordstatus == null ? null : recordstatus.trim();
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    public String getLastusertomodify() {
        return lastusertomodify;
    }

    public void setLastusertomodify(String lastusertomodify) {
        this.lastusertomodify = lastusertomodify == null ? null : lastusertomodify.trim();
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode == null ? null : companycode.trim();
    }

    public String getAirwayid() {
        return airwayid;
    }

    public void setAirwayid(String airwayid) {
        this.airwayid = airwayid == null ? null : airwayid.trim();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    public String getNotamactivationind() {
        return notamactivationind;
    }

    public void setNotamactivationind(String notamactivationind) {
        this.notamactivationind = notamactivationind == null ? null : notamactivationind.trim();
    }

    public String getControllingagency() {
        return controllingagency;
    }

    public void setControllingagency(String controllingagency) {
        this.controllingagency = controllingagency == null ? null : controllingagency.trim();
    }

    public String getRestrictionreference() {
        return restrictionreference;
    }

    public void setRestrictionreference(String restrictionreference) {
        this.restrictionreference = restrictionreference == null ? null : restrictionreference.trim();
    }

    public byte[] getRatime2() {
        return ratime2;
    }

    public void setRatime2(byte[] ratime2) {
        this.ratime2 = ratime2;
    }

    public byte[] getRemarks() {
        return remarks;
    }

    public void setRemarks(byte[] remarks) {
        this.remarks = remarks;
    }
}