package com.siniswift.syncData.controller;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siniswift.syncData.dao.SyncDataDao;
import com.siniswift.syncData.entity.RatimeEntity;
import com.siniswift.syncData.service.SyncDataService;

@RestController
public class SyncDataController {
	
	@Resource
	private SyncDataService service;
	
	@SuppressWarnings("unused")
	@RequestMapping(value="syncData")
	public HashMap<String,Object> syncData(){
		ArrayList<RatimeEntity> allRatimes = service.syncData();
		int i =1;
		return null;
	}
	
}
