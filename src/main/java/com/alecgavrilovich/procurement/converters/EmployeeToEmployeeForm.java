package com.alecgavrilovich.procurement.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.commands.EmployeeForm;
import com.alecgavrilovich.procurement.domain.Employee;

@Component
public class EmployeeToEmployeeForm implements Converter<Employee, EmployeeForm> {

	@Override
	public EmployeeForm convert(Employee employee) {
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setId(employee.getId());
		employeeForm.setUprn(employee.getUprn());
		employeeForm.setFirst_name(employee.getFirst_name());
		employeeForm.setLast_name(employee.getLast_name());
		employeeForm.setDepartment_id(employee.getDepartment_id());
		employeeForm.setPosition(employee.getPosition());
		employeeForm.setSalary(employee.getSalary());
		return employeeForm;
	}
}
