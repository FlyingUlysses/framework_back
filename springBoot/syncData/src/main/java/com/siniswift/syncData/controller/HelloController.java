package com.siniswift.syncData.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siniswift.syncData.entity.StaffEntity;
import com.siniswift.syncData.service.SayService;


@RestController
public class HelloController {
	@Resource
	private SayService service;
	
	@RequestMapping(value="/say")
	public String say() {
		ArrayList<StaffEntity> allStaffs = service.getAllStaffs();
		return "hello";
	}
	
}
