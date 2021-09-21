package com.model;

public class Employee {
	private String name;
	private String email;
	private long mobile;
	private int deptid;
	private int roleid;
	public Employee(String name, String email, long mobile, int deptid, int roleid) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.deptid = deptid;
		this.roleid = roleid;
	}
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	

}