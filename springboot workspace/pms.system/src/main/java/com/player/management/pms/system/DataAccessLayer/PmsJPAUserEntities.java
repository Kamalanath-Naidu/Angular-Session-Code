package com.player.management.pms.system.DataAccessLayer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_table")
@Data

public class PmsJPAUserEntities {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	
	private long user_id;
	
	@Column(name="first_name")
		
	private String first_name;
	
	@Column(name="last_name")
	
	private String lastname;
	
	@Column(name="email_id")
	
	private String email_id;
	
	@Column(name="passcode")
	
	private String passcode;
	
protected PmsJPAUserEntities(){
		
	}
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	//public String getFirstname() {
		//return firstname;
	//}
	//public void setFirstname(String firstname) {
		//this.firstname = firstname;
//	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	
	
	
	
	
}