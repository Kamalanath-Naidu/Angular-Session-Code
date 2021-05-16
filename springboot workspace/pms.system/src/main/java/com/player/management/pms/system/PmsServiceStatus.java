package com.player.management.pms.system;

public class PmsServiceStatus {

	private String serviceStatus;
	private String name;
	private  String email;
	private long user_id;
	

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

	
	
	public PmsServiceStatus(PmsServiceEnumStatus message, String name, String email, long user_id) {
		this.serviceStatus =message.toString();
		this.name=name;
		this.email=email;
		this.user_id=user_id;
	}
	public PmsServiceStatus(String message) {
		this.serviceStatus =message.toString();
		this.name=null;
		this.email=null;
	}

	public PmsServiceStatus(PmsServiceEnumStatus message) {
		this.serviceStatus =message.toString();
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
}
