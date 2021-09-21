package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.configuration.DBconnect;
import com.model.Employee;
import com.model.Role;

public class RoleDaoImp implements RoleDao {

	@Override
	public boolean addRole(Role r) {
		try(Connection con=DBconnect.getConnection();
				PreparedStatement pst=con.prepareStatement("insert into role values(?,?)"))
		{
			pst.setInt(1, r.getRoleid());
			pst.setString(2, r.getRolename());
			pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteRole(int eid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> getALLEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateByName(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmpByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
