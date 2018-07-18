package com.siniswift.syncComputerInfo.pojo;

import java.io.Serializable;

/**
 * @ClassName:  ComputerInfoEntity   
 * @author: WangYong 
 * @date:   2018年7月16日
 * @Description:服务器信息实体类
 */
public class ComputerInfoEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
    
    private String name;
    
    private String computerCode; 
    
    private String cpuRate;
	
	private Double memoryTotal;
	
	private Double memoryUsed;
	
	private String memoryRate;
	
	private String threadRate;
	
	private Double diskTotal;
	
	private Double diskUsed;
	
	private String diskRate;
	
	private Long threadCount;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(Long threadCount) {
		this.threadCount = threadCount;
	}

	public Double getMemoryTotal() {
		return memoryTotal;
	}

	public void setMemoryTotal(Double memoryTotal) {
		this.memoryTotal = memoryTotal;
	}

	public Double getMemoryUsed() {
		return memoryUsed;
	}

	public void setMemoryUsed(Double memoryUsed) {
		this.memoryUsed = memoryUsed;
	}

	public String getMemoryRate() {
		return memoryRate;
	}

	public void setMemoryRate(String memoryRate) {
		this.memoryRate = memoryRate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCpuRate() {
		return cpuRate;
	}

	public void setCpuRate(String cpuRate) {
		this.cpuRate = cpuRate;
	}

	public String getThreadRate() {
		return threadRate;
	}

	public void setThreadRate(String threadRate) {
		this.threadRate = threadRate;
	}

	public String getDiskRate() {
		return diskRate;
	}

	public void setDiskRate(String diskRate) {
		this.diskRate = diskRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComputerCode() {
		return computerCode;
	}

	public void setComputerCode(String computerCode) {
		this.computerCode = computerCode;
	}

	public Double getDiskTotal() {
		return diskTotal;
	}

	public void setDiskTotal(Double diskTotal) {
		this.diskTotal = diskTotal;
	}

	public Double getDiskUsed() {
		return diskUsed;
	}

	public void setDiskUsed(Double diskUsed) {
		this.diskUsed = diskUsed;
	}
	
}
