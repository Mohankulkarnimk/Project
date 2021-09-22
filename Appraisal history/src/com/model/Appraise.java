package com.model;

public class Appraise {
  private int  empid;
  private int appraisaldate ;
  private String currentrole;
  private String newrole;
  
  
public Appraise(int empid, int appraisaldate, String currentrole, String newrole) {
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


public int getAppraisaldate() {
	return appraisaldate;
}


public void setAppraisaldate(int appraisaldate) {
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
 