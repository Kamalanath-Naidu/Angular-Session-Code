package com.player.management.pms.system;

public class PmsServiceStatus {

	private String serviceStatus;
	
	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public PmsServiceStatus(String status) {
		this.serviceStatus=status;
	}
	
}
