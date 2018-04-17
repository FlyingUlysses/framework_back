package com.siniswift.flightMonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }
	
	@RequestMapping(value = "/showAirPort")
	@ResponseBody
    public ModelAndView showAirPort(ModelAndView modelAndView) {
		modelAndView.setViewName("/showAirPort");
        return modelAndView;
    }

}
