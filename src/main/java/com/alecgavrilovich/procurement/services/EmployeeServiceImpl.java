package com.alecgavrilovich.procurement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alecgavrilovich.procurement.commands.EmployeeForm;
import com.alecgavrilovich.procurement.converters.EmployeeFormToEmployee;
import com.alecgavrilovich.procurement.dao.EmployeeDao;
import com.alecgavrilovich.procurement.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private EmployeeFormToEmployee employeeFormToEmployee;

	public List<Employee> listAll() {
		return employeeDao.findAll();
	}

	public Employee getById(Integer id) {
		return employeeDao.findOne(id);
	}

	public Employee saveEmp(EmployeeForm employeeForm) {
		Employee savedEmployee = employeeFormToEmployee.convert(employeeForm);
		employeeDao.save(savedEmployee);
		return savedEmployee;
	}
	
	public Employee updateEmp(EmployeeForm employeeForm) {
		Employee updatedEmployee = employeeFormToEmployee.convert(employeeForm);
		employeeDao.update(updatedEmployee);
		return updatedEmployee;
	}

	public void delete(Integer id) {
		employeeDao.delete(id);

	}
}
