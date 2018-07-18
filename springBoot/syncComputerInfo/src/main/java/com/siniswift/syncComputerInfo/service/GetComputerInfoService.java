package com.siniswift.syncComputerInfo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.NumberFormat;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.siniswift.syncComputerInfo.config.AppBaseConfig;
import com.siniswift.syncComputerInfo.config.SigarConfig;
import com.siniswift.syncComputerInfo.pojo.ComputerInfoEntity;
import com.siniswift.syncComputerInfo.utils.PostRequestUtils;

/**
 * @ClassName:  GetComputerInfoService   
 * @author: WangYong 
 * @date:   2018年7月16日
 * @Description:获取电脑信息业务层
 */
@Service
public class GetComputerInfoService {
	

	
}
