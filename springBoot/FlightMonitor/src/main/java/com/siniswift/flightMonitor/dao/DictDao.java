package com.siniswift.flightMonitor.dao;

import com.siniswift.flightMonitor.entity.DictEntity;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface DictDao {
    int deleteByPrimaryKey(BigDecimal dictId);

    int insert(DictEntity record);

    int insertSelective(DictEntity record);

    DictEntity selectByPrimaryKey(BigDecimal dictId);

    int updateByPrimaryKeySelective(DictEntity record);

    int updateByPrimaryKey(DictEntity record);

	ArrayList<DictEntity> ListbyGroupCode(@Param("groupCode")String groupCode);
	
	ArrayList<DictEntity> ListbySeatIdAndGroupCode(@Param("groupCode")String groupCode);
	
}