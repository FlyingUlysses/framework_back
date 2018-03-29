package com.siniswift.webservice.impl;
 
import java.util.List;
 
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.siniswift.entity.StaffEntity;
import com.siniswift.mapper.StaffMapper;
import com.siniswift.model.Order;
import com.siniswift.webservice.IRemoteService;
 
 
@WebService(endpointInterface="com.siniswift.webservice.IRemoteService")
@Service
public class RemoteServiceImpl implements IRemoteService {
	
    @Autowired
	private StaffMapper dao;
	
    @SuppressWarnings("unused")
	public String showRemoteMessage(String message) {
    	StaffEntity staff = JSON.parseObject(message, StaffEntity.class);
    	dao.save(staff);
        return "You message is "+ message;
    }
 
    public String addOrder(List<Order> orders) {
    	System.out.println("调用了-----------------------");
        return JSONArray.toJSONString(orders,true);
    }
     
}