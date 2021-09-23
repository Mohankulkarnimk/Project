package com.model;

public class Appraise {
  private int  empid;
  private String appraisaldate ;
  private String currentrole;
  private String newrole;
  
  
public Appraise() {
	super();
}


public Appraise(int empid, String appraisaldate, String currentrole, String newrole) {
	super();
	this.empid = empid;
	this.appraisaldate = appraisaldate;
	this.currentrole = currentrole;
	this.newrole = newrole;
     }


public int getEmpid() {
	return empid;
}


public void setEmpid(int empid) {
	this.empid = empid;
}


public String getAppraisaldate() {
	return appraisaldate;
}


public void setAppraisaldate(String appraisaldate) {
	this.appraisaldate = appraisaldate;
}


public String getCurrentrole() {
	return currentrole;
}


public void setCurrentrole(String currentrole) {
	this.currentrole = currentrole;
}


public String getNewrole() {
	return newrole;
}


public void setNewrole(String newrole) {
	this.newrole = newrole;
}
} 
 