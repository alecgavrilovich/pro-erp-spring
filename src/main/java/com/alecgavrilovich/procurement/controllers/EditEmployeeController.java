package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alecgavrilovich.procurement.commands.EmployeeForm;
import com.alecgavrilovich.procurement.converters.EmployeeToEmployeeForm;
import com.alecgavrilovich.procurement.domain.Employee;
import com.alecgavrilovich.procurement.services.EmployeeService;

@Controller
@RequestMapping("/employees/edit")
public class EditEmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeToEmployeeForm employeeToEmployeeForm;

	@RequestMapping("/{id}")
	public String edit(@PathVariable String id, Model model) {
		Employee employee = employeeService.getById(Integer.parseInt(id));
		EmployeeForm employeeForm = employeeToEmployeeForm.convert(employee);

		model.addAttribute("employeeForm", employeeForm);
		return "employee/employee-form-edit";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String updateEmployee(EmployeeForm employeeForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "employee/employee-form-edit";
		}

		Employee updatedEmployee = employeeService.updateEmp(employeeForm);
		return "redirect:/employees/show/" + updatedEmployee.getId();
	}
}