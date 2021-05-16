package com.player.management.pms.system;

public class PmsServiceProfile {
	
	public long profile_id;
	public long user_id;
	public String EnumMessage;
	public String getEnumMessage() {
		return EnumMessage;
	}
	public void setEnumMessage(String enumMessage) {
		EnumMessage = enumMessage;
	}
	public long getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

public PmsServiceProfile(PmsServiceEnumStatus msg) {
	this.EnumMessage=msg.toString();
}

}
