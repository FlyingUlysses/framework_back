package com.siniswift.flightMonitor.pojo;

import java.util.ArrayList;

public class AirportNotam {
	
	private Long id;
	
	private String airport;
	
	private String airport_name;
	
	private String content;
	
	private String start_time;
	
	private String end_time;
	
	private ArrayList<AirportNotam> notam_list;
	
	public ArrayList<AirportNotam> getNotam_list() {
		return notam_list;
	}
	public void setNotam_list(ArrayList<AirportNotam> notam_list) {
		this.notam_list = notam_list;
	}
	public String getAirport_name() {
		return airport_name;
	}
	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
}
