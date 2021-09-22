package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.configuration.DBconnect;
import com.model.Employee;

public class EmpDaoImplement implements EmpDao {

	private static final String e = null;

	@Override
	public boolean addEmployee(Employee e) {
		try (Connection connection = DBconnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("insert into employee values(?,?,?,?,?,?)")) {
				pst.setInt(1, e.getEmpid());
				pst.setString(2, e.getName());
				pst.setString(3, e.getEmail());
				pst.setLong(4, e.getMobile());
				pst.setInt(5, e.getDeptid());
				pst.setInt(6, e.getRoleid());
				pst.executeUpdate();
				return true;
			} catch (SQLException s) {
				s.printStackTrace();
			}
			return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteEmployee(int empid) {
		try (Connection connection = DBconnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("delete from employee where empid=?")) {
				pst.setInt(1, empid);
				pst.executeUpdate();
				return true;
			} catch (SQLException ee) {
				ee.printStackTrace();
			}
		// TODO Auto-generated method stub
		return false;
	}

	
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		try (Connection connection = DBconnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("select * from employee")) {
			ArrayList<Employee> employee = new ArrayList<>();
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				Employee emp = new Employee(0, null, null, 0, 0, 0);
				emp.setEmpid(resultset.getInt(1));
				emp.setName(resultset.getString(2));
				employee.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<Employee> employee = null;
		
		return null;
	}
     
	public Map<String,Integer> getDepartmentWiseCount() throws SQLException
	{
		HashMap <String,Integer> hashmap=new HashMap<>();
		try(Connection connection=DBconnect.getConnection();
				Statement statement=connection.createStatement())
		{
			try {
				ResultSet rs=statement.executeQuery("SELECT * FROM employee INNER JOIN department ON employee.empid = department.deptid;");
				while(rs.next())
				{
					hashmap.put(rs.getString(1), rs.getInt(2));
				}
			} catch (SQLException e) {
				 e.printStackTrace();
			}
		}
		return hashmap;
		
	}
	@Override
	public boolean updateByName(int empid) {
		try (Connection connection = DBconnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("update employee set empname=? where empid=?")) {
			   // pst.setString(1, e.replace(oldChar, newChar));
			   // pst.setInt(2, e.getEmpid());
			
		     	pst.execute();
			return true;

		} catch (Exception ee) {
			ee.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
