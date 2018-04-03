package com.siniswift.webservice;

import javax.jws.WebService;

/**
 * @ClassName:  SyncService   
 * @author: wangyong 
 * @date:   2018年3月29日
 * @Description:同步服务接口
 */
@WebService
public interface SyncWebService {
	String sync(String message);
}
