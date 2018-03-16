package com.alecgavrilovich.procurement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alecgavrilovich.procurement.domain.Employee;
import com.alecgavrilovich.procurement.services.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@ModelAttribute("employees")
	public List<Employee> showAllEmp() {
		return employeeService.listAll();
	}

    @RequestMapping("")
    public String redirToList(){
        return "redirect:/employees/list";
    }

    @RequestMapping("/list")
    public String listDepartments(Model model){
        // model.addAttribute("employees", employeeService.listAll());
        return "employee/employee-list";
    }
    
    @RequestMapping("/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("employee", employeeService.getById(Integer.parseInt(id)));
        return "employee/employee";
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        employeeService.delete(Integer.valueOf(id));
        return "redirect:/employees/list";
    }
}
