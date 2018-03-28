package com.siniswift.syncData.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siniswift.syncData.dao.SyncDataDao;
import com.siniswift.syncData.entity.RatimeEntity;

@Service
public class SyncDataService {
	
	@Autowired
	private SyncDataDao dao;
	
	public ArrayList<RatimeEntity> syncData(){
		return dao.getAllRatimes();
	}
	
}
