package com.siniswift.syncComputerInfo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.util.Date;

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
	
	private static final Sigar sigar = new Sigar();
	
	@Autowired
	private AppBaseConfig config;
	
	/**
	 * @author: WangYong 
	 * @date:   2018年7月16日
	 * @Description:同步主机信息
	 */
	public void syncComputerInfo() {
		System.out.println(System.getProperty("路径------------------------------- java.library.path"));
		try {
			ComputerInfoEntity info = getComputerInfo();
			if(config.syncId != null)
				info.setId(config.syncId);
			String res = PostRequestUtils.sendForJson(config.syncUrl, JSON.toJSONString(info));
			JSONObject resMap = JSON.parseObject(res);
			Long id = resMap.getLong("id");
			if(!id.equals(config.syncId)) {
				AppBaseConfig.init();
				config.setId(id);
			}
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author: WangYong 
	 * @date:   2018年7月16日
	 * @Description:获取服务器信息
	 */
	private ComputerInfoEntity getComputerInfo() throws Exception {
		ComputerInfoEntity info = new ComputerInfoEntity();
		NumberFormat nf = NumberFormat.getNumberInstance();  
		nf.setMaximumFractionDigits(2);
		getIp(info);
		getThreadCount(info);
		getCpuInfo(sigar, nf, info);
		getMemory(sigar, nf, info);
		getDiskInfo(sigar, nf, info);
		info.setUpdateTime(new Date());
		return info;
	}
	
	/**
	 * @author: WangYong 
	 * @date:   2018年7月18日
	 * @Description:获取系统所有线程
	 */
	private void getThreadCount(ComputerInfoEntity info) {
		try {
			int count = 0;
			Process pro =null;
			BufferedReader in = null;
			try {
				String command = "wmic process list brief";
				int temp = 0;
				pro = Runtime.getRuntime().exec(command);
				in= new BufferedReader(new InputStreamReader(pro.getInputStream()));
				String line = " ";
				while ((line = in.readLine()) != null ){
					temp =0;
					if(!line.trim().isEmpty()) {
						String[] split = line.split("\\s{2,}|\\t");
						try {temp = Integer.parseInt(split[4]);} catch (Exception e) {}
						if(temp !=0) {
							count += temp;
						}
					}
				}
				info.setThreadCount((long) count);
			} catch (Exception e) {
			}finally {
				if(pro != null) {
					pro.destroy();
				}
				if(in != null) {
					in.close();
				}
			}
		} catch (Exception e) {
		}
	}
	
	/**
	 * @author: WangYong 
	 * @date:   2018年7月17日
	 * @Description:获取ip
	 */
	private void getIp(ComputerInfoEntity info) throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();   
        String ip=addr.getHostAddress().toString();
        info.setComputerCode(ip);
	}
	
	/**
	 * @author: WangYong 
	 * @date:   2018年7月17日
	 * @Description:获取磁盘信息
	 */
	private void getDiskInfo(Sigar sigar, NumberFormat nf, ComputerInfoEntity info) throws SigarException {
		double diskTotalFinal = 0;
		double diskUsedFinal = 0;
		Double diskUsedRateFinal =null;
		FileSystemUsage usage =null;
		if(!config.diskName.trim().isEmpty()) {
			usage = sigar.getFileSystemUsage(config.diskName);
			diskTotalFinal = usage.getTotal()/1024/1024;
			diskUsedFinal = Double.parseDouble(nf.format(usage.getUsed()/1024/1024));
			diskUsedRateFinal = Double.parseDouble(nf.format(usage.getUsePercent()*100));
		}else {
			FileSystem[] fileList = sigar.getFileSystemList();
			for (FileSystem fs : fileList) {
				usage = sigar.getFileSystemUsage(fs.getDirName());
				diskTotalFinal += usage.getTotal()/1024/1024;
				diskUsedFinal += usage.getUsed()/1024/1024;
			}
			diskUsedRateFinal = Double.parseDouble(nf.format(diskUsedFinal/diskTotalFinal *100));
			diskTotalFinal = Double.parseDouble(nf.format(diskTotalFinal));
			diskUsedFinal = Double.parseDouble(nf.format(diskUsedFinal));
		}
		info.setDiskUsed(diskUsedFinal);
		info.setDiskTotal(diskTotalFinal);
		info.setDiskRate(diskUsedRateFinal);
	}
	
	/**
	 * @author: WangYong 
	 * @date:   2018年7月17日
	 * @Description:获取cpu信息
	 */
	private void getCpuInfo(Sigar sigar, NumberFormat nf, ComputerInfoEntity info) throws SigarException {
		double combined = sigar.getCpuPerc().getCombined();
		double cpuUsedRate = Double.parseDouble(nf.format(combined * 100));
		info.setCpuRate(cpuUsedRate);
	}
	
	/**
	 * @author: WangYong 
	 * @date:   2018年7月17日
	 * @Description:获取内存信息
	 */
	private void getMemory(Sigar sigar, NumberFormat nf, ComputerInfoEntity info) throws SigarException {
		Mem mem = sigar.getMem();
		double memUsed = mem.getActualUsed();
		double memTotal = mem.getTotal();
		double usedPercent = mem.getUsedPercent();
		double memUsedFinal = Double.parseDouble(nf.format(memUsed/1024/1024/1024));
		double memTotalFinal =Double.parseDouble(nf.format(memTotal/1024/1024/1024));
		double usedPercetFinal = Double.parseDouble(nf.format(usedPercent));
		info.setMemoryUsed(memUsedFinal);
		info.setMemoryTotal(memTotalFinal);
		info.setMemoryRate(usedPercetFinal);
	}
	
}
