package com.player.management.pms.system.DataAccessLayer;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import com.player.management.pms.system.*;
import com.player.management.pms.system.SecurityService.Pms_Encrypt_Decrypt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "user_table")
@Data
public class PmsJPAUserEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long user_id;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String lastname;
	@Column(name = "user_name")
	private String username;
	@Column(name = "email_id")
	private String email_id;
	@Column(name = "passcode")
	private String passcode;
	@Column(name = "crypt")
	private String crypt;
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "users")//(targetEntity = com.player.management.pms.system.DataAccessLayer.PmsProfileEntities.class, mappedBy = "user_id",cascade=CascadeType.ALL)
	private List<PmsProfileEntities> profiles;



	protected PmsJPAUserEntities() {

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

	// public String getFirstname() {
	// return firstname;
	// }
	// public void setFirstname(String firstname) {
	// this.firstname = firstname;
//	}
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getCrypt() {
		return crypt;
	}

	public void setCrypt(String encrypted) {
		this.crypt = encrypted;
	}
	
	
	
	public boolean validateUserName(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		PmsJPAUserEntities user = (PmsJPAUserEntities) obj;

		System.out.println("Username Validation: " + Objects.equals(username, user.username));

		return Objects.equals(username, user.username);

	}

	public boolean validateEmailId(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		PmsJPAUserEntities user = (PmsJPAUserEntities) obj;

		System.out.println("Email Id Validation: " + Objects.equals(email_id, user.email_id));

		return Objects.equals(email_id, user.email_id);

	}

	public boolean validatePassword(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		PmsJPAUserEntities user = (PmsJPAUserEntities) obj;
		System.out.println("Password Id Validation: " + Objects.equals(passcode, user.passcode));//ende.decrypt(getCrypt(), passcode)


		return Objects.equals(passcode, user.passcode);//(crypt, user.crypt)
	}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	
	if (obj == null)
		return false;
	
	PmsJPAUserEntities user = (PmsJPAUserEntities) obj;
	
	return Objects.equals(email_id, user.email_id) && Objects.equals(passcode, user.passcode);
}



public boolean validateMailandUser(Object obj,boolean x) {

	if (this == obj)
		return true;

	if (obj == null)
		return false;
/*switch case for all conditions but now for if */
	
	PmsJPAUserEntities user = (PmsJPAUserEntities) obj;
	
	if(x==true) {
	
	System.out.println("Username and Email Id Validation: " +( Objects.equals(email_id, user.email_id) && Objects.equals(username,user.username)));

		
	return Objects.equals(email_id, user.email_id) || Objects.equals(username,user.username);
	
	
	}
	
	else if(x==false) {
	

	System.out.println("Username and Email Id Validation: "	 +( Objects.equals(email_id, user.email_id) && Objects.equals(passcode,user.passcode)));

	return Objects.equals(email_id, user.email_id) && Objects.equals(passcode,user.passcode);
}
	return true;
}



}