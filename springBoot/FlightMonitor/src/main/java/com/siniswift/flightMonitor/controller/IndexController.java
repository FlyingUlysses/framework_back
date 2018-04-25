package com.siniswift.flightMonitor.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.siniswift.flightMonitor.pojo.SimpleAirportInfo;
import com.siniswift.flightMonitor.pojo.SimpleNotam;
import com.siniswift.flightMonitor.service.FlightInfoService;
import com.siniswift.flightMonitor.service.SyncService;
import com.siniswift.flightMonitor.utils.Constants;

@Controller
public class IndexController {

	@Resource
	private FlightInfoService flightInfoService;
	
	@Resource
	private SyncService sync;
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:首页跳转
	 */
	@RequestMapping(value = "/index")
    public ModelAndView login(ModelAndView modelAndView) {
		sync.getRoute();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		modelAndView.addObject("start_time", format.format(new Date()));
		modelAndView.addObject("end_time", format.format(new Date(new Date().getTime() + Constants.GET_FIGHT_TIME) ));
        modelAndView.setViewName("index");
        return modelAndView;
    }
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:首页航班数据磁贴列表请求
	 */
	@RequestMapping(value="/index/ListFlightByTime",method=RequestMethod.POST)
	@ResponseBody
	public String ListFlightByTime(@RequestParam("type") String type,@RequestParam("start_time")String startTime,@RequestParam("end_time")String endTime) {
		return flightInfoService.ListFlightByTime(type,startTime,endTime);
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:webservice 同步航班最新数据
	 */
	@RequestMapping(value="/index/syncFlight",method=RequestMethod.POST)
	@ResponseBody
	public String syncFlight(@RequestParam("type") String type,@RequestParam("start_time")String startTime,@RequestParam("end_time")String endTime) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("flag", true);
		try {
			sync.getFlight(startTime, endTime);
		} catch (IOException e) {
			map.put("flag", false);
			map.put("msg", "同步即时数据错误！请联系管理员。");
			e.printStackTrace();
		}
		return JSON.toJSONString(map);
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:航班详情跳转
	 */
	@RequestMapping(value = "/index/showFlight")
    public ModelAndView showFlight(ModelAndView modelAndView, String start, String end, String start_name,String end_name) {
		HashMap<String, ArrayList<SimpleNotam>> map = new HashMap<String,ArrayList<SimpleNotam>>();
	    map.put("list",flightInfoService.ListNotamByFlight(start, end, start_name, end_name));  
	    modelAndView.addObject("Map",map);
		modelAndView.setViewName("/showFlight");
        return modelAndView;
    }
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:首页机场表格
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/index/reloadAirPortTable")
	@ResponseBody
    public String reloadAirPortTable() {
        return flightInfoService.getAirPortTable();
    }
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:查询一条通告影响的所有航班
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/index/showAirport/{code}")
    public ModelAndView showAirport(ModelAndView modelAndView,@PathVariable("code")String code) {
		HashMap<String, ArrayList<SimpleAirportInfo>> map = new HashMap<String,ArrayList<SimpleAirportInfo>>();
	    map.put("list",flightInfoService.getFlightListByAirPort(code));  
	    modelAndView.addObject("Map",map);  
		modelAndView.setViewName("/showAirport");
	    return modelAndView;
    }
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月20日
	 * @Description:展示席位配置页
	 */
	@RequestMapping(value = "/index/showSeatConfig")
	public ModelAndView showSeatConfig(ModelAndView mav) {
		mav.setViewName("/seatConfig");
		return mav;
	}
	
}
