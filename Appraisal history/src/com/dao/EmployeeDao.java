package com.dao;

import java.util.List;

import com.model.Employee;
import com.model.Role;

public interface EmployeeDao {

	public  boolean addRole(Role r);
	public boolean updateRole(Role r); 
	public  boolean deleteRole(int eid);
	public List<Role> getALLEmp();
	public boolean  updateByName(int id);
	public Employee getEmpByID( int id );
	public List<Role> getALLRoles();
}
