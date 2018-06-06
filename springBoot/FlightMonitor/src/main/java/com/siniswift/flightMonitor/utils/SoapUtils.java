package com.siniswift.flightMonitor.utils;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @ClassName:  SoapUtils   
 * @author: wangyong 
 * @date:   2018年5月25日
 * @Description:webService通信方式 :soap工具类
 */
public class SoapUtils {
	
	/**
	 * @author: wangyong 
	 * @throws Exception 
	 * @date:   2018年5月25日
	 * @Description:使用动态参数传参
	 */
	public static Object sendToPloxy(String url,String method,Object[] aprams) throws Exception {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient(url);
        Object[] objs = client.invoke(method, aprams);
        return objs[0];
	}
	
}
