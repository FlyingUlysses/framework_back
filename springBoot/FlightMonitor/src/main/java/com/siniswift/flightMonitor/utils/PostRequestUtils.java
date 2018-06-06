package com.siniswift.flightMonitor.utils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @ClassName:  PostRequestUtils   
 * @author: wangyong 
 * @date:   2018年5月23日
 * @Description:发送post请求的工具类
 */
public class PostRequestUtils {
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月23日
	 * @Description:通过http-post形式发送web请求，传参数map
	 */
	public static String sendForParams(String url,HashMap<String,String> map) throws Exception {
		HttpPost httppost=new HttpPost(url);
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		while(iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			params.add(new BasicNameValuePair(next.getKey(),(String) next.getValue()));
		}
		httppost.setEntity(new UrlEncodedFormEntity(params,StandardCharsets.UTF_8));
		HttpResponse response=HttpClients.createDefault().execute(httppost);
		String result=EntityUtils.toString(response.getEntity());
		return result;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月23日
	 * @Description:通过http-post形式发送web请求，传参数json
	 */
	public static String sendForJson(String url,String json) throws Exception {
		HttpPost httppost=new HttpPost(url);
		httppost.setEntity(new StringEntity(json,StandardCharsets.UTF_8));
		HttpResponse response=HttpClients.createDefault().execute(httppost);
		String result=EntityUtils.toString(response.getEntity());
		return result;
	}
	
}
