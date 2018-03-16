package com.alecgavrilovich.procurement.services;

import java.util.List;

import com.alecgavrilovich.procurement.commands.EmployeeForm;
import com.alecgavrilovich.procurement.domain.Employee;

public interface EmployeeService {

	public List<Employee> listAll();
	
	public Employee getById(Integer id);
	
	public Employee saveEmp(EmployeeForm employeeForm);
	
	public Employee updateEmp(EmployeeForm employeeForm);
	
	public void delete(Integer id);
}
