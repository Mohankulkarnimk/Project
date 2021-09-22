package com.dao;


import java.util.List;

import com.model.Employee;
import com.model.Role;

public interface RoleDao {
	public  boolean addRole(Role r);
	public boolean updateRole(Role r); 
	public  boolean deleteRole(int eid);
	public List<Role> getALLRoles();

}
