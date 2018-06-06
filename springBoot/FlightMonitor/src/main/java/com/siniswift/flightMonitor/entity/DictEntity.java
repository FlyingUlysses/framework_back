package com.siniswift.flightMonitor.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DICT
 * @author 
 */
public class DictEntity implements Serializable {
    private BigDecimal dictId;

    private String groupCode;

    private String type;

    private Short sort;

    private String code;

    private String name;

    private Short state;

    private static final long serialVersionUID = 1L;

    public BigDecimal getDictId() {
        return dictId;
    }

    public void setDictId(BigDecimal dictId) {
        this.dictId = dictId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }
}