package com.siniswift.flightMonitor.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.siniswift.flightMonitor.dao.flight.SeatDao;
import com.siniswift.flightMonitor.entity.SeatEntity;
import com.siniswift.flightMonitor.pojo.LoginConfig;
import com.siniswift.flightMonitor.utils.Constants;

@Controller
public class LoginController {
	
	@Resource
	private SeatDao seatDao;
	
	@RequestMapping(value = "/")
    public ModelAndView loginIndex(ModelAndView modelAndView) {
		HashMap<String, ArrayList<SeatEntity>> map = new HashMap<String,ArrayList<SeatEntity>>();
	    map.put("list",seatDao.listAllSeat());  
	    modelAndView.addObject("Map",map);
        modelAndView.setViewName("login");
        return modelAndView;
    }
	
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView mdv,HttpSession session,String seatId,String seatName) {
		if(seatId ==null || seatName ==null) {
			mdv.setViewName("redirect:/");
		}else {
			LoginConfig config = new LoginConfig();
			config.setSeatId(seatId);
			config.setSeatName(seatName);
			session.setAttribute(Constants.LOGIN_CONFIG, config);
			mdv.setViewName("redirect:/index");
		}
		return mdv;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(ModelAndView mdv,HttpSession session) {
		session.removeAttribute(Constants.LOGIN_CONFIG);
		mdv.setViewName("redirect:/");
		return mdv;
	}
	
}
