package com.siniswift.flightMonitor.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.entity.ExportRecordEntity;

public interface ExportRecordDao {
    int deleteByPrimaryKey(String recordId);

    int insert(ExportRecordEntity record);

    int insertSelective(ExportRecordEntity record);

    ExportRecordEntity selectByPrimaryKey(String recordId);

    int updateByPrimaryKeySelective(ExportRecordEntity record);

    int updateByPrimaryKey(ExportRecordEntity record);

	ArrayList<ExportRecordEntity> listBySeatId(@Param("seatId")String seatId,@Param("startTime") Date start_time, @Param("endTime") Date end_time);

	void deleteBySeatId(@Param("seatId")String seatId);

	void isnertList(@Param("list")ArrayList<ExportRecordEntity> recordList);
	
	void updateList(@Param("list")ArrayList<ExportRecordEntity> recordList);

	
}