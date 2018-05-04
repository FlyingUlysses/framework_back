package com.siniswift.flightMonitor.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siniswift.flightMonitor.entity.FlightEntity;
import com.siniswift.flightMonitor.pojo.ExcelData;
import com.siniswift.flightMonitor.pojo.LoginConfig;
import com.siniswift.flightMonitor.service.FlightService;
import com.siniswift.flightMonitor.utils.Constants;
import com.siniswift.flightMonitor.utils.ExportExcelUtils;

@RestController
public class ExcelController {
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value = "/excel", method = RequestMethod.GET)
    public void excel(HttpSession session,HttpServletResponse response,String start_time,String end_time,String type) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList<>();
        titles.add("航班名称");
        titles.add("起飞机场");
        titles.add("落地机场");
        titles.add("预计起飞时间");
        titles.add("预计到达时间");
        data.setTitles(titles);
        LoginConfig config  = (LoginConfig) session.getAttribute(Constants.LOGIN_CONFIG);
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        ArrayList<FlightEntity> flightList = flightService.ListFlightByTime(type, start_time, end_time, config.getSeatId());
        List<List<Object>>rows = new ArrayList<>();
        for (FlightEntity flight : flightList) {
        	List<Object> row = new ArrayList<>();
        	row.add(flight.getFlightNumber());
        	row.add(flight.getDepCityName());
        	row.add(flight.getArrCityName());
        	row.add(format.format( flight.getStd() ));
        	row.add(format.format( flight.getSta() ));
        	rows.add(row);
		}

        data.setRows(rows);
        //生成本地
        /*File f = new File("c:/test.xlsx");
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();*/
        ExportExcelUtils.exportExcel(response,"航班情况.xlsx",data);
    }
}
