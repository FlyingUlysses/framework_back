package com.siniswift.flightMonitor.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siniswift.flightMonitor.dao.ErrorRecordDao;
import com.siniswift.flightMonitor.entity.ErrorRecordEntity;
import com.siniswift.flightMonitor.utils.Constants;

/**
 * @ClassName:  ErrorService   
 * @author: wangyong 
 * @date:   2018年5月21日
 * @Description:错误处理类
 */
@Service
public class ErrorService {
	
	@Autowired
	private ErrorRecordDao errorDao;
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月21日
	 * @Description:保存异常
	 */
	public void saveError(String type,String remark,Exception e) {
		ErrorRecordEntity error = new ErrorRecordEntity();
		error.setType(type);
		error.setRemark(remark);
		if(e.toString().length() <= 800) {
			error.setContent(e.toString());
		}else {
			error.setContent(e.toString().substring(0, 800));
		}
		error.setErrorId(UUID.randomUUID().toString());
		error.setCreateTime( new Date());
		errorDao.insert(error);
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月21日
	 * @Description:根据时间和类型查询报错
	 */
	public ArrayList<ErrorRecordEntity> listByTimeAndType(String start, String end, String type) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startTime = format.parse(start);
		Date endTime = new Date(format.parse(end).getTime() + (1000*3600*24));
		ArrayList<ErrorRecordEntity> res = new ArrayList<ErrorRecordEntity>();
		if(type.equals(Constants.ERROR_TYPE_BACK)) {
			res = errorDao.listByTimeAndType( startTime,  endTime, Constants.ERROR_TYPE_BACK);
		}else if(type.equals(Constants.ERROR_TYPE_FRONT)) {
			res = errorDao.listByTimeAndType( startTime,  endTime, Constants.ERROR_TYPE_FRONT);
		}else {
			res = errorDao.listByTimeAndType( startTime,  endTime, null);
		}
		return res;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月21日
	 * @Description:根据id查询错误内容
	 */
	public ErrorRecordEntity selectById(String id) {
		return errorDao.selectContentByid(id);
	}
	
}
