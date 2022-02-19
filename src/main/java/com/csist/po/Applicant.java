package com.csist.po;

/**
 * 申请用户表
 * 
 * @author admin
 *
 */
public class Applicant {
	public int id;
	public String name;
	public String password;
	public String phone;

	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Applicant(int id, String name, String password, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	public Applicant(String name, String password, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	public Applicant(String password, String phone) {
		super();
		this.password = password;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
