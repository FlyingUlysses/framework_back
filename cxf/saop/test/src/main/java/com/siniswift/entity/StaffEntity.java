package com.siniswift.entity;

import java.io.Serializable;

public class StaffEntity implements Serializable{
	
	private static final long serialVersionUID = 7276568332487738005L;
	
	private Integer id;
	private String name;
	private Integer state;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
