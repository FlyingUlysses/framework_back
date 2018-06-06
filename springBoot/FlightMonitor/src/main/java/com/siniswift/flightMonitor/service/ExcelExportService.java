package com.siniswift.flightMonitor.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siniswift.flightMonitor.dao.AirportDao;
import com.siniswift.flightMonitor.dao.DictDao;
import com.siniswift.flightMonitor.dao.ExportRecordDao;
import com.siniswift.flightMonitor.dao.FlightDao;
import com.siniswift.flightMonitor.dao.FlightRestrictionDao;
import com.siniswift.flightMonitor.entity.DictEntity;
import com.siniswift.flightMonitor.entity.ExportRecordEntity;
import com.siniswift.flightMonitor.entity.FlightEntity;
import com.siniswift.flightMonitor.entity.FlightRestrictionEntity;
import com.siniswift.flightMonitor.pojo.ExcelData;
import com.siniswift.flightMonitor.pojo.LoginConfig;
import com.siniswift.flightMonitor.utils.Constants;
import com.siniswift.flightMonitor.utils.ExportExcelUtils;

/**
 * @ClassName:  ExcelExportService   
 * @author: wangyong 
 * @date:   2018年5月15日
 * @Description:excel导出应用层
 */
@Service
public class ExcelExportService {
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private ExportRecordDao exportDao;
	
	@Autowired
	private FlightRestrictionDao restrictionDao;
	
	@Autowired
	private DictDao dict;
	
	@Autowired
	private AirportDao airportDao;
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月15日
	 * @Description:导出excel
	 */
	public void exportExcel(HttpSession session, HttpServletResponse response, String start_time, String end_time,
			String type, String is_start, Integer downloadType) throws Exception {
		ArrayList<ExcelData> dataList = new ArrayList<ExcelData>();
        List<String> titles = new ArrayList<>();
        titles.add("是否增量");
        titles.add("航班状态");
        titles.add("航班名称");
        titles.add("起飞机场");
        titles.add("落地机场");
        titles.add("预计起飞时间");
        titles.add("预计到达时间");
        LoginConfig config  = (LoginConfig) session.getAttribute(Constants.LOGIN_CONFIG);
        ArrayList<DictEntity> dictList = dict.ListbySeatIdAndGroupCode(Constants.RESTRICTION_CODE_GROUP);
        ArrayList<String> dictCodeList = new ArrayList<String>();
        for (DictEntity dict : dictList) {
			titles.add(dict.getName());
			dictCodeList.add(dict.getCode());
		}
        ArrayList<FlightEntity> reloadExcelTable = reloadExcelTable(type,is_start, start_time, end_time, config.getSeatId(),downloadType);
        setSheetData(dataList, titles,reloadExcelTable,is_start,config.getSeatId(),dictCodeList,start_time,end_time);
        //生成本地
        /*
	        File f = new File("c:/test.xlsx");
	        FileOutputStream out = new FileOutputStream(f);
	        ExportExcelUtils.exportExcel(data, out);
	        out.close();
         */
        StringBuilder sb = setExcelName(start_time, type, is_start, downloadType);
        ExportExcelUtils.exportExcel(response,sb.toString(),dataList);
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月15日
	 * @Description:设置excel名称
	 */
	private StringBuilder setExcelName(String start_time, String type, String is_start, Integer downloadType) {
		StringBuilder sb = new StringBuilder();
        sb.append(start_time.replace(":", "").replace(" ", "").replace("-", ""));
        sb.append("-");
        sb.append(start_time.replace(":", "").replace(" ", "").replace("-", ""));
        if(is_start.equals("started"))
        	sb.append("_航行中");
        else if(is_start.equals("wait"))
        	sb.append("_未起飞");
        if(type.equals("error"))
        	sb.append("_受限的");
        if(downloadType.equals(1))
        	sb.append("_增量");
        sb.append("_航班分析.xlsx");
		return sb;
	}
	
	/**
	 * @author: wangyong 
	 * @throws ParseException 
	 * @date:   2018年5月15日
	 * @Description:设置报表导出的sheet页
	 */
	private void setSheetData(ArrayList<ExcelData> dataList, List<String> titles, ArrayList<FlightEntity> flightList,
			String isStart,String seatId,ArrayList<String> dictCodeList,String start,String end) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        ArrayList<FlightRestrictionEntity> infoList = null;
        Date start_time = format.parse(start);
		Date end_time = format.parse(end);
        saveOrUpdateExportRecord(seatId, flightList,start_time,end_time);
        infoList = restrictionDao.ListByFlightArrray(flightList,dictCodeList);
        if(isStart.equals("all")) {
        	setRowsData(dataList, titles, format, flightList,"全部航班",infoList,dictCodeList);
        }else if( isStart.equals("started")) {
        	setRowsData(dataList, titles, format, flightList,"航行中",infoList,dictCodeList);
        }else if( isStart.equals("wait")) {
        	setRowsData(dataList, titles, format, flightList,"未起飞",infoList,dictCodeList);
        }
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月15日
	 * @Description:保存或更新导出记录
	 */
	private void saveOrUpdateExportRecord(String seatId, ArrayList<FlightEntity> flightList,Date start_time,Date end_time) {
        ArrayList<ExportRecordEntity> oldList = exportDao.listBySeatId(seatId,start_time,end_time);
        ArrayList<ExportRecordEntity> updateList = new ArrayList<ExportRecordEntity>();
        ArrayList<ExportRecordEntity> insertList = new ArrayList<ExportRecordEntity>();
        if(flightList.size() >0) {
        	boolean heaveRecord = false;
        	for (FlightEntity flight : flightList) {
        		heaveRecord = false;
        		for (ExportRecordEntity old : oldList) {
					if(old.getFlightId().equals(flight.getFlightId()) && old.getIsLimited() != flight.getIsLimited()) {
						old.setIsLimited(flight.getIsLimited());
						updateList.add(old);
						heaveRecord = true;
					}
				}
        		if(!heaveRecord) {
        			ExportRecordEntity record = new ExportRecordEntity();
        			record.setFlightId(flight.getFlightId());
        			record.setIsLimited(flight.getIsLimited());
        			record.setSeatId(seatId);
        			record.setRecordId(UUID.randomUUID().toString());
        			insertList.add(record);
        		}
			}
        }
        if(insertList.size() >0) 
        	exportDao.isnertList(insertList);
        if(updateList.size() >0)
        	exportDao.updateList(updateList);
	}
	
	/**
	 * @author: wangyong 
	 * @date:   2018年5月15日
	 * @Description:设置报表导出的rows数据
	 */
	private void setRowsData(ArrayList<ExcelData> dataList, List<String> titles, SimpleDateFormat format,ArrayList<FlightEntity> flightList,String sheetName,
			ArrayList<FlightRestrictionEntity> infoList,ArrayList<String> dictCodeList)  {
		ExcelData data = new ExcelData();
        List<List<Object>>rows = new ArrayList<>();
        data.setName(sheetName);
        data.setTitles(titles);
        boolean flag =true;
        for (FlightEntity flight : flightList) {
        	List<Object> row = new ArrayList<>();
        	if(flight.getDownloadType().equals(1)) 
        		row.add("增量");
        	else
        		row.add("");
        	if(flight.getIsStart().equals(1))
        		row.add("航行中");
        	else
        		row.add("等待起飞");
        	row.add(flight.getFlightNumber());
        	row.add(flight.getDepCityName());
        	row.add(flight.getArrCityName());
        	row.add(format.format( flight.getStd() ));
        	row.add(format.format( flight.getSta() ));
        	for (String code : dictCodeList) {
        		flag =true;
				for (FlightRestrictionEntity info : infoList) {
					if(info.getFlightId().equals(flight.getFlightId()) && code.equals(info.getDictCode())) {
						row.add("受限");
						flag =false;
						break;
					}
				}
				if(flag) {
					row.add("");
				}
			}
        	rows.add(row);
		}
        data.setRows(rows);
        dataList.add(data);
	}
	
	/**
	 * @author: wangyong 
	 * @return 
	 * @date:   2018年5月14日
	 * @Description:根据excel页table的需求查询并返回数据
	 */
	public ArrayList<FlightEntity> reloadExcelTable(String type, String isStart, String start, String end, String seatId,Integer dowanloadType) {
		ArrayList<FlightEntity> flightList = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date startTime = format.parse(start);
			Date endTime = format.parse(end);
			String airportListStr = airportDao.strListairport(seatId);
			if(airportListStr!= null &&  airportListStr.trim().length() > 0) {
				String[] airportList = airportListStr.split(",");
				if(airportList.length >0) {
					if(type.equals("all")) {
						flightList = listDataByTimeAndSeat(isStart,  startTime, endTime, airportList, null,seatId,dowanloadType);
					}else if(type.equals("error")) {
						flightList = listDataByTimeAndSeat(isStart, startTime, endTime, airportList,1,seatId,dowanloadType);
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return flightList;
	}
	
	/**
	 * @author: wangyong 
	 * @return 
	 * @date:   2018年5月14日
	 * @Description:抽取通用列表数据获取
	 */
	public ArrayList<FlightEntity> listDataByTimeAndSeat(String isStart, Date startTime,Date endTime, String[] airportList,
			Integer type,String seatId,Integer dowanloadType) {
		ArrayList<ExportRecordEntity> recordList = exportDao.listBySeatId(seatId,startTime,endTime);
		ArrayList<FlightEntity> flightList = flightDao.listByTimeAndSeat(isStart,startTime, endTime,airportList,type);
		ArrayList<FlightEntity> haveRecordList = new ArrayList<FlightEntity>();
		ArrayList<FlightEntity> newRecordList = new ArrayList<FlightEntity>();
		boolean haveRecord = false;
		if(flightList.size() >0) {
			for (FlightEntity flight : flightList) {
				haveRecord = false;
				for (ExportRecordEntity record : recordList) {
					if(record.getFlightId().equals(flight.getFlightId())) {
						haveRecord = true;
						if(record.getIsLimited() == flight.getIsLimited()) {
							flight.setDownloadType(0);
							haveRecordList.add(flight);
						}else {
							if(flight.getIsLimited().equals(0)) {
								flight.setDownloadType(1);
								newRecordList.add(flight);
							}else if (flight.getIsLimited().equals(1)) {
								flight.setDownloadType(1);
								newRecordList.add(flight);
							}
						}
					}
				}
				if(!haveRecord) {
					newRecordList.add(flight);
					flight.setDownloadType(1);
				}
			}
		}
		if(dowanloadType.equals(1)) {
			return newRecordList;
		}else {
			ArrayList<FlightEntity> allList = new ArrayList<FlightEntity>();
			allList.addAll(newRecordList);
			allList.addAll(haveRecordList);
			return allList;
		}
	}
	
}
