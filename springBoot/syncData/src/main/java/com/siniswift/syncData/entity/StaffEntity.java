package com.siniswift.syncData.entity;

import java.io.Serializable;

public class StaffEntity implements Serializable{
	private static final long serialVersionUID = -2617854341260771575L;
	
	private Integer id;
	private String name;
	
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
}
