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
				PreparedStatement pst = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?)")) {
				pst.setInt(1, e.getEmpid());
				pst.setString(2, e.getName());
				pst.setString(3, e.getEmail());
				pst.setLong(4, e.getMobile());
				pst.setInt(5, e.getRoleid());
				pst.setInt(6, e.getSalary());
				pst.setInt(7, e.getDeptid());
			
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
				Employee emp = new Employee();
				emp.setEmpid(resultset.getInt(1));
				emp.setName(resultset.getString(2));
				emp.setEmail(resultset.getString(3));
				emp.setMobile(resultset.getLong(4));
				emp.setDeptid(resultset.getInt(5));
				emp.setRoleid(resultset.getInt(6));
				employee.add(emp);
			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//List<Employee> employee = null;
		
		return null;
	}
     
	
	@Override
	public boolean updateByName(int empid) {
		try (Connection connection = DBconnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("update employee set empname=? where empid=?")) {
			   //pst.setString(1, e.replace(?, ?));
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
	
	public List<Employee> report2() {
		// TODO Auto-generated method stub
		try (Connection connection = DBconnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT * FROM employee e where empid In (select empid from appraisal where currrentrole='intern' and newrole='manager')")) {
			ArrayList<Employee> employee = new ArrayList<>();
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				Employee emp = new Employee();
				emp.setEmpid(resultset.getInt(1));
				emp.setName(resultset.getString(2));
				emp.setEmail(resultset.getString(3));
				emp.setMobile(resultset.getLong(4));
				emp.setRoleid(resultset.getInt(5));
				emp.setSalary(resultset.getInt(6));
				emp.setDeptid(resultset.getInt(7));
			
				employee.add(emp);
			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public List<Employee> report3() {
		// TODO Auto-generated method stub
		try (Connection connection = DBconnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("select * from employee e where not exists (SELECT empid FROM appraisal a where a.empid=e.empid)")) {
			ArrayList<Employee> employee = new ArrayList<>();
			ResultSet resultset = pst.executeQuery();
			while (resultset.next()) {
				Employee emp = new Employee();
				emp.setEmpid(resultset.getInt(1));
				emp.setName(resultset.getString(2));
				emp.setEmail(resultset.getString(3));
				emp.setMobile(resultset.getLong(4));
				emp.setRoleid(resultset.getInt(5));
				emp.setSalary(resultset.getInt(6));
				emp.setDeptid(resultset.getInt(7));
			
				employee.add(emp);
			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		}
		
		public List<Employee> report4() {
			// TODO Auto-generated method stub
			try (Connection connection = DBconnect.getConnection();
					PreparedStatement pst = connection.prepareStatement("select * from employee where  empid = ( SELECT empid FROM appraisal.appraisal group by empid order by count(*) desc limit 1)")) {
				ArrayList<Employee> employee = new ArrayList<>();
				ResultSet resultset = pst.executeQuery();
				while (resultset.next()) {
					Employee emp = new Employee();
					emp.setEmpid(resultset.getInt(1));
					emp.setName(resultset.getString(2));
					emp.setEmail(resultset.getString(3));
					emp.setMobile(resultset.getLong(4));
					emp.setRoleid(resultset.getInt(5));
					emp.setSalary(resultset.getInt(6));
					emp.setDeptid(resultset.getInt(7));
				
					employee.add(emp);
				}
				return employee;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
	}

}
