package com.siniswift.client.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.siniswift.client.SyncWebService;
import com.siniswift.dao.RtimeDao;
import com.siniswift.entity.RtimeEntity;

public class ClientTest {
	
	@Autowired
	private RtimeDao dao;
	
	@Test
	public void test() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(SyncWebService.class);
		factory.setAddress("http://localhost:8090/ws/sync");
		SyncWebService service = (SyncWebService) factory.create();
		RtimeEntity entity = dao.selectByPrimaryKey("f76f21ca-8bb8-4bec-8c47-373c49a19860");
		entity.setCodeStatus("审核通过");
		service.sync(JSON.toJSONString(entity));
	}
	
}
