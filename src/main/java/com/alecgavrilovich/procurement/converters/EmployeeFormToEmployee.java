package com.alecgavrilovich.procurement.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alecgavrilovich.procurement.commands.EmployeeForm;
import com.alecgavrilovich.procurement.domain.Employee;

@Component
public class EmployeeFormToEmployee implements Converter<EmployeeForm, Employee> {
	
	@Override
	public Employee convert(EmployeeForm employeeForm) {
		Employee employee = new Employee();
		if (employeeForm.getId() != null && !StringUtils.isEmpty(employeeForm.getId())) {
			employee.setId(Integer.valueOf(employeeForm.getId()));
		}
		employee.setUprn(employeeForm.getUprn());
		employee.setFirst_name(employeeForm.getFirst_name());
		employee.setLast_name(employeeForm.getLast_name());
		employee.setDepartment_id(employeeForm.getDepartment_id());
		employee.setPosition(employeeForm.getPosition());
		employee.setSalary(employeeForm.getSalary());
		employee.setStatus(employeeForm.getStatus());
		return employee;
	}
}
