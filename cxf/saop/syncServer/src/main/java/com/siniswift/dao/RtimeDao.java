package com.siniswift.dao;

import com.siniswift.entity.RtimeEntity;

public interface RtimeDao {
    int deleteByPrimaryKey(String rtimeId);

    int insert(RtimeEntity record);
    
    int insertSelective(RtimeEntity record);

    RtimeEntity selectByPrimaryKey(String rtimeId);

    int updateByPrimaryKeySelective(RtimeEntity record);
    
    int updateState(String codeRestriction);
    
    int selectByKey(String key);

}