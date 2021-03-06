package com.player.management.pms.system;

public class PmsServiceStatus {

	private String serviceStatus;
	private String name;
	private  String email;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	
	
	public PmsServiceStatus(PmsServiceEnumStatus message, String name, String email) {
		this.serviceStatus =message.toString();
		this.name=name;
		this.email=email;
	}
	public PmsServiceStatus(String message) {
		this.serviceStatus =message.toString();
		this.name=null;
		this.email=null;
	}

	public PmsServiceStatus(PmsServiceEnumStatus message) {
		this.serviceStatus =message.toString();
	}
	
}
