package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		// TODO Auto-generated method stub
		try(Connection con=DBconnect.getConnection();
			PreparedStatement pst=con.prepareStatement("delete  from role   where roleid=?"))
			{
			  pst.setInt(1, eid);
			  pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public List<Role> getALLEmp() {
		// TODO Auto-generated method stub
		try(Connection con=DBconnect.getConnection();
				PreparedStatement pst=con.prepareStatement("select *  from role"))
				{
			      ArrayList<Role> rolelist =new ArrayList<Role>();
			      ResultSet  rs = pst.executeQuery();
			      while(rs.next())
			      {
			    	Role r =new Role();
			    	r.setRoleid(rs.getInt(1));
			    	r.setRolename(rs.getString(2));
			    	 
			      }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	@Override
	public boolean updateRole(Role r) {
		
		// TODO Auto-generated method stub
		try(Connection con=DBconnect.getConnection();
			PreparedStatement pst=con.prepareStatement("update role  set rolename=? where roleid=?"))
		{
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Role> getALLRoles() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
