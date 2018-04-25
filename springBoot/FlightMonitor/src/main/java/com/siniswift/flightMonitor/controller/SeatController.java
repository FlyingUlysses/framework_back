package com.siniswift.flightMonitor.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siniswift.flightMonitor.entity.flight.AirportEntity;
import com.siniswift.flightMonitor.entity.flight.SeatEntity;
import com.siniswift.flightMonitor.pojo.CommonResMsg;
import com.siniswift.flightMonitor.service.SeatService;

/**
 * @ClassName:  SeatController   
 * @author: wangyong 
 * @date:   2018年4月23日
 * @Description:席位controller
 */
@Controller
public class SeatController {
	
	@Resource
	private SeatService seat;
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月23日
	 * @Description:加载所有席位表
	 */
	@RequestMapping(value="/seat/listAllSeat",method= RequestMethod.GET)
	@ResponseBody
	public ArrayList<SeatEntity> listAllSeat() {
		return seat.listAllSeat();
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月23日
	 * @Description:加载所有机场
	 */
	@RequestMapping(value="/seat/listAllAirport",method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<AirportEntity> listAllAirport() {
		return seat.listAllAirport();
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月24日
	 * @Description:新增或更新席位配置
	 */
	@RequestMapping(value="/seat/saveOrUpdate",method = RequestMethod.POST)
	@ResponseBody
	public CommonResMsg saveOrUpdate(@RequestParam(value = "name")String name,@RequestParam(value ="id")String id,@RequestParam(value = "listAirport") String listAirport) {
		CommonResMsg res = seat.saveOrUpdate(id,name,listAirport);
		return res;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月24日
	 * @Description:根据选择席位显示席位配置
	 */
	@RequestMapping(value="/seat/showSeat",method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<AirportEntity> showSeat(@RequestParam(value="seatId")String seatId) {
		return seat.showSeat(seatId);
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月25日
	 * @Description:删除席位配置，逻辑删除
	 */
	@RequestMapping(value="/seat/delete",method = RequestMethod.GET)
	@ResponseBody
	public CommonResMsg delete(@RequestParam(value = "id" )String id) {
		return seat.delete(id);
	}
	
}
