package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alecgavrilovich.procurement.commands.EmployeeForm;
import com.alecgavrilovich.procurement.domain.Employee;
import com.alecgavrilovich.procurement.services.EmployeeService;

@Controller
@RequestMapping("/employees/new")
public class NewEmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("")
	public String newEmployee(Model model) {
		model.addAttribute("employeeForm", new EmployeeForm());
		return "employee/employee-form";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveEmployee(EmployeeForm employeeForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "employee/employee-form";
		}

		Employee savedEmployee = employeeService.saveEmp(employeeForm);
		return "redirect:/employees/show/" + savedEmployee.getId();
	}
}
