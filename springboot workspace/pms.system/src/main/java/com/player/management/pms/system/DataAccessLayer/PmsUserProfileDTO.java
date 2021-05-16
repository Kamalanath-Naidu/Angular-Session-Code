package com.player.management.pms.system.dataAccessLayer;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import com.player.management.pms.system.*;

@Data
public class PmsUserProfileDTO {
	@Id

	private long user_id;
	private String username;
	private String email_id;
	private long profile_id;
	private String first_name;
	private String last_name;
	private String dob;
	private String nuemail_id;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String gender;
	private String undergrade;
	private String postgrade;
	private String certfication;
	private String techeng;
	private String exp;
	private String preproject;

	// u.user_id,u.email_id,p.profile_id
	// ,p.first_name,p.last_name,p.nuemail_id,p.phone,p.gender,p.undergrade,p.postgrade,p.techeng,p.exp,p.preproject
	public PmsUserProfileDTO(long user_id,
			// String username,
			String email_id, long profile_id, String first_name, String last_name,
			// String dob,
			String nuemail_id,
			// String address1,
			// String address2,
			// String city,
			// String state,
			// String zip,
			String phone, String gender, String undergrade, String postgrade,
			// String certfication,
			String techeng, String exp, String preproject) {
		this.user_id = user_id;
		this.username = username;
		this.profile_id = profile_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.nuemail_id = nuemail_id;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.gender = gender;
		this.undergrade = undergrade;
		this.postgrade = postgrade;
		this.certfication = certfication;
		this.techeng = techeng;
		this.exp = exp;
		this.preproject = preproject;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNuemail_id() {
		return nuemail_id;
	}

	public void setNuemail_id(String nuemail_id) {
		this.nuemail_id = nuemail_id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUndergrade() {
		return undergrade;
	}

	public void setUndergrade(String undergrade) {
		this.undergrade = undergrade;
	}

	public String getPostgrade() {
		return postgrade;
	}

	public void setPostgrade(String postgrade) {
		this.postgrade = postgrade;
	}

	public String getCertfication() {
		return certfication;
	}

	public void setCertfication(String certfication) {
		this.certfication = certfication;
	}

	public String getTecheng() {
		return techeng;
	}

	public void setTecheng(String techeng) {
		this.techeng = techeng;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getPreproject() {
		return preproject;
	}

	public void setPreproject(String preproject) {
		this.preproject = preproject;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
}
