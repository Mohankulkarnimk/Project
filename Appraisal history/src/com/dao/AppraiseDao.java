package com.dao;

import java.util.List;

import com.model.Appraise;
import com.model.Employee;
import com.model.Role;

public interface AppraiseDao {
	
boolean addAppraisal(Appraise ob);
public List<Appraise> getALLAppraisal();
//boolean addAppraisal(Role ob);



}
