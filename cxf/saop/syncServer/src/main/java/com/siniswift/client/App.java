package com.siniswift.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import com.siniswift.dao.RtimeDao;
import com.siniswift.entity.RtimeEntity;

public class App {
	
	public void run(RtimeDao dao) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(SyncWebService.class);
		factory.setAddress("http://localhost:8090/ws/sync");
		SyncWebService service = (SyncWebService) factory.create();
		RtimeEntity entity = new RtimeEntity();
		entity.setRtimeId("f76f21ca-8bb8-4bec-8c47-373c49a19861");
		entity.setCodeStatus("审核通过");
		int kkk = dao.insertSelective(entity);
		service.sync(kkk+"");
	}
}
