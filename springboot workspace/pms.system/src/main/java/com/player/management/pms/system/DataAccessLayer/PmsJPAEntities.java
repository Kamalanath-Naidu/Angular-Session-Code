package com.player.management.pms.system.DataAccessLayer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Player_table")
@Data
public class PmsJPAEntities {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ply_id")
	private long plyid;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="address1")
	private String address1;
	@Column(name="address2")
	private String address2;
	
	protected PmsJPAEntities(){
		
	}

	public long getPlyid() {
		return plyid;
	}

	public void setPlyid(long plyid) {
		this.plyid = plyid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	
}
