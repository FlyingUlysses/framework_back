package com.siniswift.flightMonitor.pojo;

public class Route {
	
	//航线id
	private String routeId;
	
	// 航线走向
	private String cfp;
	
	//公司航路编码
	private String codeName;
	
	//当前期用户
	private String user;
	
	//航班起飞时刻（UTC时间）
	private String dataTime;
	
	//航班巡航高度 (单位海里) 
	private Double lvl; 
	
	// 验证数据类型，1动态数据，0静态数据，-1两种数据都验证      
	private Integer checkDataType;  
	
	//其他航班条件
	private RouteCondition rtecond;
	
	//是否受限
	private Boolean state;
	
	//相关内容
	private String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public Boolean getState() {
		return state;
	}
	
	public void setState(Boolean state) {
		this.state = state;
	}
	
	public String getCfp() {
		return cfp;
	}
	
	public void setCfp(String cfp) {
		this.cfp = cfp;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getDataTime() {
		return dataTime;
	}
	
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	
	public Double getLvl() {
		return lvl;
	}
	
	public void setLvl(Double lvl) {
		this.lvl = lvl;
	}
	
	public Integer getCheckDataType() {
		return checkDataType;
	}
	
	public void setCheckDataType(Integer checkDataType) {
		this.checkDataType = checkDataType;
	}
	
	public RouteCondition getRtecond() {
		return rtecond;
	}
	
	public void setRtecond(RouteCondition rtecond) {
		this.rtecond = rtecond;
	}
	
}