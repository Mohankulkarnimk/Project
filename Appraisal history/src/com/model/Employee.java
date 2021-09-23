package com.model;

public class Employee {
	private int empid;
	private String name;
	private String email;
	private long mobile;
	private int deptid;
	private int roleid;
	private int salary;

	
	public Employee(int empid, String name, String email, long mobile, int deptid, int salary,int roleid) {
		super();
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.deptid = deptid;
		this.roleid = roleid;
		this.salary = salary;
	}





	


	public int getSalary() {
		return salary;
	}




	public void setSalary(int salary) {
		this.salary = salary;
	}




	public Employee() {
		// TODO Auto-generated constructor stub
	}




	public int getEmpid() {
		return empid;
	}




	public void setEmpid(int empid) {
		this.empid = empid;
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




	public String toString() {
	
		return "Employee [empid=" + empid + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", deptid="
				+ deptid + ", roleid=" + roleid + "]";
}

}
	