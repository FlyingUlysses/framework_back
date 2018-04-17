package com.siniswift.flightMonitor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Controller;

import com.siniswift.flightMonitor.service.SyncService;

@Controller
public class SyncController implements Job{
	
	@Resource
	private SyncService job;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		String now = format.format(new Date());
		String end = format.format(new Date(new Date().getTime() + 6 * 3600 *1000));
		try {
			job.getFlight(now, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println( "同步数据完成： "+now +"-----------"+end );
	}

}
