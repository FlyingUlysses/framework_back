package com.siniswift.flightMonitor.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.siniswift.flightMonitor.entity.ErrorRecordEntity;

public interface ErrorRecordDao {
    int deleteByPrimaryKey(String errorId);

    int insert(ErrorRecordEntity record);

    int insertSelective(ErrorRecordEntity record);

    ErrorRecordEntity selectByPrimaryKey(String errorId);

    int updateByPrimaryKeySelective(ErrorRecordEntity record);

    int updateByPrimaryKey(ErrorRecordEntity record);

	ArrayList<ErrorRecordEntity> listByTimeAndType(@Param("startTime")Date startTime, @Param("endTime")Date endTime, @Param("type")String  type);

	ErrorRecordEntity selectContentByid(@Param("id")String id);
}