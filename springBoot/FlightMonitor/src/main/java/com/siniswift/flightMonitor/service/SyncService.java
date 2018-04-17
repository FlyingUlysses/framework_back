package com.siniswift.flightMonitor.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.siniswift.flightMonitor.dao.aips.RouteDao;
import com.siniswift.flightMonitor.dao.flight.SyncFlightInfoDao;
import com.siniswift.flightMonitor.entity.flight.SyncFlightInfoEntity;
import com.siniswift.flightMonitor.pojo.SimpleRoute;
import com.siniswift.flightMonitor.utils.Constants;

/**
 * @ClassName:  SyncFlightService   
 * @author: wangyong 
 * @date:   2018年4月13日
 * @Description:同步efb数据
 */
@Service
public class SyncService  {
	
	@Autowired
	private SyncFlightInfoDao flightDao;
	
	@Autowired
	private RouteDao dao;
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:通过webservice 获取实时至6小时内notam信息
	 */
	@SuppressWarnings("rawtypes")
	public void getFlight(String start,String end) throws ClientProtocolException, IOException {
		HttpPost httppost=new HttpPost(Constants.GET_FLIGHT_URL);
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("startDate",start));
		params.add(new BasicNameValuePair("endDate",end));
		httppost.setEntity(new UrlEncodedFormEntity(params,StandardCharsets.UTF_8));
		HttpResponse response=HttpClients.createDefault().execute(httppost);
		if(response.getStatusLine().getStatusCode()==200){
			String result=EntityUtils.toString(response.getEntity());
			Map map  = (Map)JSON.parse(result);
			String bodyJson = map.get("Body").toString();
			List<SyncFlightInfoEntity> list = JSON.parseArray(bodyJson, SyncFlightInfoEntity.class);
			for (SyncFlightInfoEntity record : list) {
				flightDao.saveOrUpdateByFlightId(record);
			}
		}
	}
	
	/**
	 * @author: 获取route数据 
	 * @date:   2018年4月17日
	 * @Description:TODO
	 */
	@SuppressWarnings("unused")
	public void getRoute() {
		String user = dao.getActiveUser();
		if(user != null) {
			ArrayList<SimpleRoute> routeList = dao.getRouteListByAirport(user, "ZBAA", "ZSSS");
			int i =1;
		}
	}
	
}
