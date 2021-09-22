package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmpDao {

	public boolean addEmployee(Employee e);

	public boolean deleteEmployee(int empid);

	public List<Employee> getAllEmployee();

	public boolean updateByName(int empid);

	public Employee getEmpById(int empid);
}
