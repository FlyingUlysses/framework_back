package com.siniswift.flightMonitor.pojo;

import java.util.Date;

public class SimpleNotam {
	
	private Long importantId;
	
	private Long itemId; 
	
	private String airport;
	
	private Date start;
	
	private Date end;
	
	private String startStr;
	
	private String endStr;
	
	private String airport_name;
	
	private String content;
	
	
	
	public String getStartStr() {
		return startStr;
	}
	public void setStartStr(String startStr) {
		this.startStr = startStr;
	}
	public String getEndStr() {
		return endStr;
	}
	public void setEndStr(String endStr) {
		this.endStr = endStr;
	}
	public String getAirport_name() {
		return airport_name;
	}
	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getImportantId() {
		return importantId;
	}
	public void setImportantId(Long importantId) {
		this.importantId = importantId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
	
	
}
