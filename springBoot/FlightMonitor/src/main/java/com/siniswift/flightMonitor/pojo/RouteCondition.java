package com.siniswift.flightMonitor.pojo;

public class RouteCondition {
	//验证时是否考虑航路规则
	private Boolean checkRule;
	
	//飞行航行速度（单位海里）
	private Integer  cruiseSpeed;
	
	//高度浮动范围 （单位海里）
	private Integer CruiseRange; 
	
//--------------------------------------   飞机性能相关     ----------------------
	// 机型
	private String codeIcaoAcftType;
	
	//飞机类型 （水上/陆地）
	private String airplanType;	
	
	//发动机类型 
	private String codeTypeEngine;
	
	//发动机数量
	private String codeEngineNo;
	
	//航班类型（国内/国际）
	private String codeType; 
	
	//飞行规则（目视/仪表）
	private String codeRule; 
	
	//飞行状态(定期/非定期)
	private String codeStatus; 	
	
	//是否军事飞行
	private String codeMil; 
	
	//飞行目的
	private String codePurpose;
	
	//机载设备与能力
	private String codeCapability;
	
	public Boolean getCheckRule() {
		return checkRule;
	}
	
	public void setCheckRule(Boolean checkRule) {
		this.checkRule = checkRule;
	}
	
	public Integer getCruiseSpeed() {
		return cruiseSpeed;
	}
	
	public void setCruiseSpeed(Integer cruiseSpeed) {
		this.cruiseSpeed = cruiseSpeed;
	}
	
	public Integer getCruiseRange() {
		return CruiseRange;
	}
	
	public void setCruiseRange(Integer cruiseRange) {
		CruiseRange = cruiseRange;
	}

	public String getCodeIcaoAcftType() {
		return codeIcaoAcftType;
	}
	
	public void setCodeIcaoAcftType(String codeIcaoAcftType) {
		this.codeIcaoAcftType = codeIcaoAcftType;
	}
	
	public String getAirplanType() {
		return airplanType;
	}
	
	public void setAirplanType(String airplanType) {
		this.airplanType = airplanType;
	}
	
	public String getCodeTypeEngine() {
		return codeTypeEngine;
	}
	
	public void setCodeTypeEngine(String codeTypeEngine) {
		this.codeTypeEngine = codeTypeEngine;
	}
	
	public String getCodeEngineNo() {
		return codeEngineNo;
	}
	
	public void setCodeEngineNo(String codeEngineNo) {
		this.codeEngineNo = codeEngineNo;
	}
	
	public String getCodeType() {
		return codeType;
	}
	
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	public String getCodeRule() {
		return codeRule;
	}
	
	public void setCodeRule(String codeRule) {
		this.codeRule = codeRule;
	}
	
	public String getCodeStatus() {
		return codeStatus;
	}
	
	public void setCodeStatus(String codeStatus) {
		this.codeStatus = codeStatus;
	}
	
	public String getCodeMil() {
		return codeMil;
	}
	
	public void setCodeMil(String codeMil) {
		this.codeMil = codeMil;
	}
	
	public String getCodePurpose() {
		return codePurpose;
	}
	
	public void setCodePurpose(String codePurpose) {
		this.codePurpose = codePurpose;
	}
	
	public String getCodeCapability() {
		return codeCapability;
	}
	
	public void setCodeCapability(String codeCapability) {
		this.codeCapability = codeCapability;
	}

}
