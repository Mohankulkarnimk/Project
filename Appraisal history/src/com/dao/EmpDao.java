package com.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.model.Employee;

public interface EmpDao {

	public boolean addEmployee(Employee e);

	public boolean deleteEmployee(int empid);

	public List<Employee> getAllEmployee();
	public List<Employee> report2();
	public List<Employee> report3();
	public List<Employee> report4();
	public boolean updateByName(int empid);

	public Employee getEmpById(int empid);
	
	
}
