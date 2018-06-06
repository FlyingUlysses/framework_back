package com.siniswift.flightMonitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.siniswift.flightMonitor.config.AppBaseConfig;
import com.siniswift.flightMonitor.pojo.CommonResMsg;
import com.siniswift.flightMonitor.utils.Constants;
import com.siniswift.flightMonitor.utils.SyncTask;

/**
 * @ClassName:  ConfigService   
 * @author: wangyong 
 * @date:   2018年5月24日
 * @Description:简单配置的通用应用层
 */
@Service
public class ConfigService {
	
	@Autowired
	private ErrorService errorService;
	
	@Autowired
	private AppBaseConfig appBaseConfig;
	
	/**
	 * @author: wangyong 
	 * @return 
	 * @date:   2018年5月24日
	 * @Description:保存分析设置
	 */
	public CommonResMsg saveAnnalyze(String getInterval, String pageTimeGetFlight, String waitInterval, String waitInit,
			String startedInterval, String startedInit) {
		CommonResMsg res = new CommonResMsg();
		try {
			AppBaseConfig.init();
			appBaseConfig.saveAll(getInterval, pageTimeGetFlight, waitInterval, waitInit, startedInterval, startedInit);
		} catch (Exception e) {
			res.setFlag(false);
			res.setMsg("保存分析出错，请检查操作是否正确！");
			errorService.saveError(Constants.ERROR_TYPE_FRONT, "保存分析设置", e);
			e.printStackTrace();
		}
		res.setFlag(true);
		return res;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月30日
	 * @Description:展示席位配置
	 */
	public void showAnnalyze(ModelAndView mav) {
		mav.addObject("getInterval",SyncTask.timeToString(appBaseConfig.timeGetFlightInterval));
		mav.addObject("pageGetFlight",SyncTask.timeToString(appBaseConfig.pageTimeGetFlight));
		mav.addObject("startedInterval",SyncTask.timeToString(appBaseConfig.timeStartedFlightInterval));
		mav.addObject("startedInit",SyncTask.timeToString(appBaseConfig.timeStartedFlightInit));
		mav.addObject("waitInterval", SyncTask.timeToString(appBaseConfig.timeWaitFlightInterval));
		mav.addObject("waitInit", SyncTask.timeToString(appBaseConfig.timeWaitFlightInit));
	}

}
