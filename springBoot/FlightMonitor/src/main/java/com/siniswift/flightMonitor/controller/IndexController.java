package com.siniswift.flightMonitor.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.siniswift.flightMonitor.entity.FlightEntity;
import com.siniswift.flightMonitor.pojo.CommonResMsg;
import com.siniswift.flightMonitor.pojo.LoginConfig;
import com.siniswift.flightMonitor.pojo.SimpleNotam;
import com.siniswift.flightMonitor.service.NotamService;
import com.siniswift.flightMonitor.service.FilghtService;
import com.siniswift.flightMonitor.utils.Constants;

@Controller
public class IndexController {
	
	@Resource
	private FilghtService flightService;
	
	@Resource
	private NotamService NotamService;
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:首页跳转
	 */
	@RequestMapping(value = "/index")
    public ModelAndView login(HttpSession session,ModelAndView mdv) {
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		LoginConfig config = (LoginConfig) session.getAttribute("loginConfig");
		mdv.addObject("start_time", format.format(new Date()));
		mdv.addObject("end_time", format.format(new Date(new Date().getTime() + Constants.TIME_GET_FIGHT) ));
		mdv.addObject("seat_name",config.getSeatName());
		mdv.setViewName("/index");
        return mdv;
    }
	
	/**
	 * @author: wangyong 
	 * @throws ParseException 
	 * @date:   2018年4月17日
	 * @Description:首页航班数据磁贴列表请求
	 */
	@RequestMapping(value="/index/ListFlightByTime",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<FlightEntity> ListFlightByTime(@RequestParam("type") String type,@RequestParam("start_time")String startTime,@RequestParam("end_time")String endTime,HttpSession session) throws ParseException {
		LoginConfig config = (LoginConfig) session.getAttribute("loginConfig");
		return flightService.ListFlightByTime(type,startTime,endTime,config.getSeatId());
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:webservice 同步航班最新数据
	 */
	@RequestMapping(value="/index/syncFlight",method=RequestMethod.POST)
	@ResponseBody
	public CommonResMsg syncFlight(@RequestParam("type") String type,@RequestParam("start_time")String start,@RequestParam("end_time")String end) {
		CommonResMsg res = new CommonResMsg();
		res.setFlag(true);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date startTime = format.parse(start);
			Date endTime = format.parse(end);
			flightService.getListFlightByWeb(startTime, endTime);
			flightService.ListNotTackOffByTime(startTime, endTime);
		} catch (Exception e) {
			res.setFlag(false);
			res.setMsg("同步失败");
		}
		return res;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月17日
	 * @Description:航班详情跳转
	 */
	@RequestMapping(value = "/index/showFlight")
    public ModelAndView showFlight(ModelAndView modelAndView, String flightId) {
		HashMap<String, ArrayList<SimpleNotam>> map = new HashMap<String,ArrayList<SimpleNotam>>();
	    map.put("list",flightService.getRestrictionInfo(flightId));  
	    modelAndView.addObject("Map",map);
		modelAndView.setViewName("/showFlight");
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
