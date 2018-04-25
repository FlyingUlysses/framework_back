package com.siniswift.flightMonitor.service.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siniswift.flightMonitor.dao.flight.AirportDao;
import com.siniswift.flightMonitor.dao.flight.AirportSeatDao;
import com.siniswift.flightMonitor.dao.flight.SeatDao;
import com.siniswift.flightMonitor.entity.flight.AirportEntity;
import com.siniswift.flightMonitor.entity.flight.SeatEntity;
import com.siniswift.flightMonitor.pojo.CommonResMsg;

/**
 * @ClassName:  SeatService   
 * @author: wangyong 
 * @date:   2018年4月24日
 * @Description:席位相关服务层
 */
@Service
public class SeatService {
	
	@Autowired
	private SeatDao seatDao;
	
	@Autowired
	private AirportDao airportDao;
	
	@Autowired
	private AirportSeatDao airportSeatDao;
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月23日
	 * @Description:加载席位列表
	 */
	public ArrayList<SeatEntity> listAllSeat() {
		ArrayList<SeatEntity> seatList = seatDao.listAllSeat();
		return seatList;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月23日
	 * @Description:加载所有机场
	 */
	public ArrayList<AirportEntity> listAllAirport() {
		ArrayList<AirportEntity> listAllAirport = airportDao.listAllAirport();
		return listAllAirport;
	}
	
	/**
	 * @author: wangyong 
	 * @return 
	 * @date:   2018年4月23日
	 * @Description:保存或更新席位信息
	 */
	@Transactional(value="efbTransactionManager",timeout=36000,rollbackFor=Exception.class)
	public CommonResMsg saveOrUpdate(String id,String name,String listAirportStr) {
		CommonResMsg res = new CommonResMsg();
		try {
			if(id.trim().isEmpty()) {//id为空，表明该条数据为新增
				int count = seatDao.haveSeatByName(name);
				if(count == 0) {
					String uuid = UUID.randomUUID().toString();
					SeatEntity seat = new SeatEntity();
					seat.setSeatId(uuid);
					seat.setSeatName(name);
					seat.setState(1);
					seat.setCreateTime(new Date());
					seatDao.insertSelective(seat);
					airportSeatDao.deleteBySeat(uuid);
					if(listAirportStr.contains(",")) {
						String[] listAirport = listAirportStr.split(",");
						airportSeatDao.saveList(uuid,listAirport);
					}
					res.setFlag(true);
				}else {
					res.setFlag(false);
					res.setMsg("席位名称已存在，请勿重复添加!");
				}
			}else {
				SeatEntity seat = seatDao.selectByPrimaryKey(id);
				if(seat != null) {
					airportSeatDao.deleteBySeat(seat.getSeatId());
					if(listAirportStr.contains(",")) {
						String[] listAirport = listAirportStr.split(",");
						airportSeatDao.saveList(seat.getSeatId(),listAirport);
					}
					res.setFlag(true);
				}else {
					res.setFlag(false);
					res.setMsg("未获取到需要更新的数据，请确认操作是否正确。");
				}
			}
		} catch (Exception e) {
			res.setFlag(false);
			res.setMsg("配置席位出错，请联系管理员");
		}
		return res;
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月24日
	 * @Description:根据选择席位展示席位配置
	 */
	public ArrayList<AirportEntity> showSeat(String seatId) {
		return airportDao.showSeat(seatId);
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年4月25日
	 * @Description:删除席位配置，逻辑删除
	 */
	public CommonResMsg delete(String id) {
		CommonResMsg res = new CommonResMsg();
		try {
			SeatEntity seat = seatDao.selectByPrimaryKey(id);
			if(seat != null) {
				seat.setState(0);
				seatDao.updateByPrimaryKeySelective(seat);
				res.setFlag(true);
			}else {
				res.setFlag(false);
				res.setMsg("未找到需要删除的席位，请确认操作是否正确。");
			}
			
		} catch (Exception e) {
			res.setFlag(false);
			res.setMsg("删除席位出错，请联系管理员");
		}
		return res;
	}
	
}
