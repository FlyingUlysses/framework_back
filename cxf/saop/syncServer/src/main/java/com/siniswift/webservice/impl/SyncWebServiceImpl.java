package com.siniswift.webservice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.siniswift.client.App;
import com.siniswift.dao.RtimeDao;
import com.siniswift.entity.Result;
import com.siniswift.entity.RtimeEntity;
import com.siniswift.utils.MessageConstants;

/**
 * @ClassName:  SyncServiceImpl 
 * @author: wangyong
 * @date:   2018年3月29日
 * @Description:同步接口实现类
 */
@WebService(endpointInterface="com.siniswift.webservice.SyncWebService")
public class SyncWebServiceImpl {
	
	@Autowired
	private RtimeDao dao;
	
	public String sync(String message) {
		ArrayList<Result> resList = new ArrayList<Result>();
		List<RtimeEntity> allList = JSON.parseArray(message, RtimeEntity.class);
		Result res;
		for (RtimeEntity rtime : allList) {
			res = new Result();
			rtime.setRtimeId(UUID.randomUUID().toString());
			if(rtime.getValDeleted().equals(1)) {
				if(dao.selectByKey(rtime.getCodeRestriction()) <0) {
					setResultFailure(res, rtime, MessageConstants.ERROR_LOSSDATA);
				}else {
					try {
						dao.updateByPrimaryKeySelective(rtime);
						setResultSuccsess(res, rtime);
					}catch (Exception e) {
						setResultFailure(res, rtime, subException(e.toString()));
					}
				}
			}else if(rtime.getValDeleted().equals(0)) {
				if (dao.selectByKey(rtime.getCodeRestriction()) >0) {
					try {
						dao.updateByPrimaryKeySelective(rtime);
						setResultSuccsess(res, rtime);
					} catch (Exception e) {
						setResultFailure(res, rtime, subException(e.toString()));
					}
				}else {
					try {
						dao.insertSelective(rtime);
						setResultSuccsess(res, rtime);
					} catch (Exception e) {
						setResultFailure(res, rtime, subException(e.toString()));
					}
				}
			}else {
				setResultFailure(res, rtime, MessageConstants.ERROR_ISDELTED_FIELD);
			}
			resList.add(res);
		}
		return JSON.toJSONString(resList);
	}
	
	//设置结果为成功
	private void setResultSuccsess(Result res, RtimeEntity rtime) {
		res.setCODE_RESTRICTION(rtime.getCodeRestriction());
		res.setState(1);
	}
	
	//设置结果为失败
	private void setResultFailure(Result res, RtimeEntity rtime,String exceptionMsg) {
		res.setCODE_RESTRICTION(rtime.getCodeRestriction());
		res.setState(0);
		res.setMessage(exceptionMsg);
	}
	
	//sql异常，截取第一条错误信息有效内容，其他异常截取前100错误信息返回
	private String subException(String str) {
		try {
			int start = str.indexOf("java.sql.SQLException");
			int end = str.indexOf(System.lineSeparator(), start);
			return " error: "+str.substring(start,end);
		} catch (Exception e) {
			if(str.length() > 100)
				return str.substring(0,100);
			else
				return str;
		}
	}
	
}
