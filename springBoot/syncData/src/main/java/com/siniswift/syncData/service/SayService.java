package com.siniswift.syncData.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siniswift.syncData.dao.SayDao;
import com.siniswift.syncData.entity.StaffEntity;

@Service
public class SayService {
	@Autowired
	private SayDao dao;
	
	public ArrayList<StaffEntity> getAllStaffs() {
		return dao.getAllStaffs();
	}
	
}
