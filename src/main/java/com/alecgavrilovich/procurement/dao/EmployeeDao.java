package com.alecgavrilovich.procurement.dao;

import java.util.List;

import com.alecgavrilovich.procurement.domain.Employee;

public interface EmployeeDao {
	
	List<Employee> findAll();
	
	Employee findOne(Integer id);
	
	void save(Employee employee);
	
	void update(Employee employee);
	
	void delete(Integer id);
	
}
