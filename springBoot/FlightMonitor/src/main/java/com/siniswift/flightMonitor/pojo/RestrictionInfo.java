package com.siniswift.flightMonitor.pojo;

import java.util.ArrayList;

/**
 * @ClassName:  RestrictionResult   
 * @author: wangyong 
 * @date:   2018年5月2日
 * @Description:航班限制信息结果类
 */
public class RestrictionInfo {
	
	private ArrayList<SimpleNotam> notamList;

	public ArrayList<SimpleNotam> getNotamList() {
		return notamList;
	}

	public void setNotamList(ArrayList<SimpleNotam> notamList) {
		this.notamList = notamList;
	}
	
}
