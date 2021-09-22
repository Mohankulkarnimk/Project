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
	public boolean deleteRole(int rid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try(Connection con=DBconnect.getConnection();
			PreparedStatement pst=con.prepareStatement("delete  from role  where roleid=?"))
			{
			  pst.setInt(1, rid);
			  pst.executeUpdate();
			  return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	

	
	@Override
	public boolean updateRole(Role r) {
		
		// TODO Auto-generated method stub
		try(Connection con=DBconnect.getConnection();
			PreparedStatement pst=con.prepareStatement("update role  set rolename=? where roleid=?"))
		{
			 pst.setLong(1,r.getRoleid());
			 pst.setInt(2, r.getRoleid());
			 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Role> getALLRoles() {
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
			    	rolelist.add(r);
			    	 
			      }
			      return rolelist;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		// TODO Auto-generated method stub
		return null;
	}
	

}
