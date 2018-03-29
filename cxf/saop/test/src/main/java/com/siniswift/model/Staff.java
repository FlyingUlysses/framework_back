package com.siniswift.model;

import java.io.Serializable;

public class Staff implements Serializable{
	private static final long serialVersionUID = -3513713294430288558L;
	
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
