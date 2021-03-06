package com.player.management.pms.system.DataAccessLayer;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.player.management.pms.system.*;
import com.player.management.pms.system.SecurityService.Pms_Encrypt_Decrypt;

@Entity
@Table(name = "profile")
@Data

public class PmsProfileEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profile_id")
	private long profile_id;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "dob")
	private String dob;
	@Column(name = "nuemail_id")
	private String nuemail_id;
	@Column(name = "address1")
	private String address1;
	@Column(name = "address2")
	private String address2;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "zip")
	private String zip;
	@Column(name = "phone")
	private String phone;
	@Column(name = "gender")
	private String gender;
	@Column(name = "undergrade")
	private String undergrade;
	@Column(name = "postgrade")
	private String postgrade;
	@Column(name = "certfication")
	private String certfication;
	@Column(name = "techeng")
	private String techeng;
	@Column(name = "exp")
	private String exp;
	@Column(name = "preproject")
	private String preproject;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private PmsJPAUserEntities users;
	
	
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

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public PmsJPAUserEntities getUsers() {
		return users;
	}
	public void setUsers(PmsJPAUserEntities users) {
		this.users = users;
	}

	
	
	
}
