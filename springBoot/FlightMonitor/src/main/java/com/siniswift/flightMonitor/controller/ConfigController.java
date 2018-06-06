package com.siniswift.flightMonitor.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.siniswift.flightMonitor.pojo.CommonResMsg;
import com.siniswift.flightMonitor.service.ConfigService;

/**
 * @ClassName:  ConfigController   
 * @author: wangyong 
 * @date:   2018年5月24日
 * @Description:系统设置基础页
 */
@Controller
public class ConfigController {
	
	@Resource
	private ConfigService configService;
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月10日
	 * @Description:展示席位配置
	 */
	@RequestMapping(value="/config/showSeatConfig")
	public ModelAndView showSeatConfig(ModelAndView mav) {
		mav.setViewName("/config/seatConfig");
		return mav;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月24日
	 * @Description:展示分析设置
	 */
	@RequestMapping(value="/config/showAnnalyzeConfig")
	public ModelAndView showAnnalyzeConfig(ModelAndView mav) {
		configService.showAnnalyze(mav);
		mav.setViewName("/config/annalyzeConfig");
		return mav;
	}

	/**
	 * @author: wangyong 
	 * @date:   2018年5月24日
	 * @Description:保存分析设置
	 */
	@RequestMapping(value = "/config/saveAnnalyze",method=RequestMethod.POST)
	@ResponseBody
	public CommonResMsg saveAnnalyze(String getInterval,String pageTimeGetFlight,String waitInterval,String waitInit,String startedInterval,String startedInit) {
		return configService.saveAnnalyze(getInterval,pageTimeGetFlight,waitInterval,waitInit,startedInterval,startedInit);
	}
	
}
