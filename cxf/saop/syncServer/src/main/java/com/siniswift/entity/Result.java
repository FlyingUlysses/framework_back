package com.siniswift.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * @ClassName:  Result   
 * @author: wangyong 
 * @date:   2018年3月29日
 * @Description:返回数据结果
 */
public class Result implements Serializable{
	private static final long serialVersionUID = -6054510729089387965L;
	
	private Integer State;
	private String CODE_RESTRICTION;
	private String Message;
	
	@JSONField(name = "State")
	public Integer getState() {
		return State;
	}
	public void setState(Integer state) {
		State = state;
	}
	@JSONField(name = "CodeRestriction")
	public String getCODE_RESTRICTION() {
		return CODE_RESTRICTION;
	}
	public void setCODE_RESTRICTION(String CODE_RESTRICTION) {
		this.CODE_RESTRICTION = CODE_RESTRICTION;
	}
	@JSONField(name = "Message")
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	
	
}
