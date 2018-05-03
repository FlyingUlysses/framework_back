package com.siniswift.flightMonitor.service;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.siniswift.flightMonitor.dao.aips.RouteDao;
import com.siniswift.flightMonitor.dao.flight.AirportDao;
import com.siniswift.flightMonitor.dao.flight.FlightDao;
import com.siniswift.flightMonitor.entity.FlightEntity;
import com.siniswift.flightMonitor.pojo.RestrictionInfo;
import com.siniswift.flightMonitor.pojo.SimpleNotam;
import com.siniswift.flightMonitor.pojo.SimpleRoute;
import com.siniswift.flightMonitor.utils.Constants;

/**
 * @ClassName:  SyncFlightService   
 * @author: wangyong 
 * @date:   2018年4月13日
 * @Description:同步航班数据接口
 */
@Service
public class FilghtService  {
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private RouteDao routeDao;
	
	@Autowired
	private AirportDao airportDao;
	
	@Resource
	private NotamService notamService;
	
	/**
	 * @author: wangyong 
	 * @throws ParseException 
	 * @date:   2018年4月17日
	 * @Description:首页磁贴展示
	 */
	public ArrayList<FlightEntity> ListFlightByTime(String type,String start,String end,String seatId) {
		ArrayList<FlightEntity> res = new ArrayList<FlightEntity>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date startTime = format.parse(start);
			Date endTime = format.parse(end);
			String airportListStr = airportDao.strListairport(seatId);
			if(airportListStr!= null &&  airportListStr.trim().length() > 0 ) {
				String[] airportList = airportListStr.split(",");
				if(airportList.length >0) {
					if(type.equals("all")) {
						res = flightDao.listByTimeAndSeat(startTime, endTime,airportList);
					}else if(type.equals("error")) {
						res = flightDao.listErrorByTimeAndSeat(startTime,endTime,airportList);
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:通过webservice 获取实时至6小时内notam信息
	 */
	@SuppressWarnings("rawtypes")
	public void getListFlightByWeb(Date startTime,Date endTime)  {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			HttpPost httppost=new HttpPost(Constants.URL_GET_FLIGHT);
			List<NameValuePair> params=new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("startDate",format.format(startTime)));
			params.add(new BasicNameValuePair("endDate",format.format(endTime)));
			httppost.setEntity(new UrlEncodedFormEntity(params,StandardCharsets.UTF_8));
			HttpResponse response=HttpClients.createDefault().execute(httppost);
			if(response.getStatusLine().getStatusCode()==200){
				String result=EntityUtils.toString(response.getEntity());
				Map map  = (Map)JSON.parse(result);
				String bodyJson = map.get("Body").toString();
				List<FlightEntity> list = JSON.parseArray(bodyJson, FlightEntity.class);
				for (FlightEntity flight : list) {
					if(flightDao.selectByPrimaryKey(flight.getFlightId()) != null) {
						flightDao.updateByPrimaryKeySelective(flight);
					}else {
						flight.setState(Constants.FLIGHT_STATE_NORMAL);
						flight.setUpdateTime(new Date());
						flightDao.insertSelective(flight);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("-----------------------------------------同步航班数据出错-----------------------------");
			e.printStackTrace();
		}
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月2日
	 * @Description:查询没有起飞的航班并分析是否受限
	 */
	public void ListNotTackOffByTime(Date startTime,Date endTime){
		ArrayList<FlightEntity> flightList = flightDao.listNotTackOffByTime(startTime, endTime);
		annalyzeFlight(flightList, startTime, endTime);
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月2日
	 * @Description:航班分析
	 */
	public void annalyzeFlight(ArrayList<FlightEntity> flightList,Date startTime,Date endTime) {
		ArrayList<SimpleNotam> notamList = notamService.getNotam(startTime, endTime);
		ArrayList<FlightEntity> resList = notamService.analyzeFlightByNotam(flightList, startTime, endTime, notamList);
		for (FlightEntity flight : resList) {
			flightDao.updateByPrimaryKeySelective(flight);
		}
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月2日
	 * @Description:获取受限航班受限信息
	 */
	public ArrayList<SimpleNotam> getRestrictionInfo(String id) {
		FlightEntity flight = flightDao.selectByPrimaryKey(id);
		RestrictionInfo rest = JSON.parseObject(flight.getRestrictionResult(), RestrictionInfo.class);
		return rest.getNotamList();
	}
	
	/**
	 * @author: 获取route数据 
	 * @date:   2018年4月17日
	 * @Description:获取航线数据，并通过webservice判断是否可行，分析数据后存储
	 */
	@SuppressWarnings("unused")
	public void getRoute() {
		String user = routeDao.getActiveUser();
		if(user != null) {
			ArrayList<SimpleRoute> routeList = routeDao.getRouteListByAirport(user, "ZBAA", "ZSSS");
			int i =1;
		}
	}
	
}
