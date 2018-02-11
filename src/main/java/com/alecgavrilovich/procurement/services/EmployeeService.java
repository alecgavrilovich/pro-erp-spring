package com.alecgavrilovich.procurement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alecgavrilovich.procurement.commands.EmployeeForm;
import com.alecgavrilovich.procurement.converters.EmployeeFormToEmployee;
import com.alecgavrilovich.procurement.domain.Employee;
import com.alecgavrilovich.procurement.repositories.EmployeeRepository;

@Service
public class EmployeeService implements ProcurementService<Employee, EmployeeForm> {
	
	private EmployeeRepository employeeRepository;
	private EmployeeFormToEmployee employeeFormToEmployee;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository,
			EmployeeFormToEmployee employeeFormToEmployee
	) {
		this.employeeRepository = employeeRepository;
		 this.employeeFormToEmployee = employeeFormToEmployee;
	}

	@Override
	public List<Employee> listAll() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}

	@Override
	public Employee getById(Integer id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public Employee saveOrUpdate(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public void delete(Integer id) {
		employeeRepository.delete(id);

	}

	@Override
	public Employee saveOrUpdateObjectForm(EmployeeForm employeeForm) {
		Employee savedEmployee = saveOrUpdate(employeeFormToEmployee.convert(employeeForm));

		System.out.println("Saved Employee Id: " + savedEmployee.getId());
		return savedEmployee;
	}
}
