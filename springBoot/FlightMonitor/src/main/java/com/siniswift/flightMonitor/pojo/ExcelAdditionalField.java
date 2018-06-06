package com.siniswift.flightMonitor.pojo;

/**
 * @ClassName:  ExcelAdditionalField   
 * @author: wangyong 
 * @date:   2018年5月15日
 * @Description:导出excel报表的额外补充项
 */
public class ExcelAdditionalField {
	
	private Boolean haveNotam;
	
	private Boolean haveRoute;

	public Boolean getHaveNotam() {
		return haveNotam;
	}

	public void setHaveNotam(Boolean haveNotam) {
		this.haveNotam = haveNotam;
	}

	public Boolean getHaveRoute() {
		return haveRoute;
	}

	public void setHaveRoute(Boolean haveRoute) {
		this.haveRoute = haveRoute;
	}
	
}
