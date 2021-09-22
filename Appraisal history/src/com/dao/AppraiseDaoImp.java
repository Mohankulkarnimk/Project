package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.configuration.DBconnect;
import com.model.Appraise;

import com.model.Role;
public class AppraiseDaoImp implements AppraiseDao {

	@Override
	public boolean addAppraisal(Appraise ob) {
	
			try(Connection con=DBconnect.getConnection();
					PreparedStatement pst=con.prepareStatement("insert into  appraisal values(?,?,?,?)"))
			{
				
				pst.setInt(1, ob.getEmpid());
				pst.setString(2, ob.getAppraisaldate());
				pst.setString(3, ob.getCurrentrole());
				pst.setString(4, ob.getNewrole());
				pst.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// TODO Auto-generated method stub
		return false;
	}}

	
	

		
	

		
	


