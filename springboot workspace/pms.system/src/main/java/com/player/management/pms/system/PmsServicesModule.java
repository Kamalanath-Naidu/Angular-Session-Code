package com.player.management.pms.system;

public class PmsServicesModule {

	private String message;
	
	public PmsServicesModule(String message) {
		this.message=message;
	};

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
