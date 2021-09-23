package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.configuration.DBconnect;
import com.model.Appraise;
import com.model.Employee;
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
	}


	public List<Appraise> getALLAppraisal() {
		// TODO Auto-generated method stub
		try(Connection con=DBconnect.getConnection();
				PreparedStatement pst=con.prepareStatement("select *  from appraisal"))
				{
			      ArrayList<Appraise> Applist =new ArrayList<Appraise>();
			      ResultSet  rs = pst.executeQuery();
			      while(rs.next())
			      {
			    	  Appraise r =new Appraise();
					 r.setEmpid(rs.getInt(1));
			    	 r.setAppraisaldate(rs.getString(2));
			    	 r.setCurrentrole(rs.getString(3));
			    	 r.setNewrole(rs.getString(4));
			    	 Applist.add(r);			      }
			      return Applist;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return null;
	}
	

	private void add(Appraise r) {
		// TODO Auto-generated method stub
		
	}}

	
	

		
	

		
	


