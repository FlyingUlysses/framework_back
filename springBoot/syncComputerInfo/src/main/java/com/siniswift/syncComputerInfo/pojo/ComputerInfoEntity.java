package com.siniswift.syncComputerInfo.pojo;

import java.io.Serializable;
import java.util.Date;

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
    
    private Double cpuRate;
    
    private Double memoryTotal;
    
    private Double memoryUsed;
	
	private Double memoryRate;
	
	private Double diskTotal;
	
	private Double diskUsed;
	
	private Double diskRate;
	
	private Long threadCount;
	
	private Date updateTime;
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Double getCpuRate() {
		return cpuRate;
	}

	public void setCpuRate(Double cpuRate) {
		this.cpuRate = cpuRate;
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

	public Double getMemoryRate() {
		return memoryRate;
	}

	public void setMemoryRate(Double memoryRate) {
		this.memoryRate = memoryRate;
	}

	public Double getDiskRate() {
		return diskRate;
	}

	public void setDiskRate(Double diskRate) {
		this.diskRate = diskRate;
	}

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
