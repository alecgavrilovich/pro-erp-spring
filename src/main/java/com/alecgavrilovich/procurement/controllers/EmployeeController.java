package com.alecgavrilovich.procurement.controllers;

// import javax.validation.Valid;

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
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
    private EmployeeToEmployeeForm employeeToEmployeeForm;

    @Autowired
    public void setProductToProductForm(EmployeeToEmployeeForm employeeToEmployeeForm) {
        this.employeeToEmployeeForm = employeeToEmployeeForm;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("")
    public String redirToList(){
        return "redirect:/employee/list";
    }

    @RequestMapping("/list")
    public String listDepartments(Model model){
        model.addAttribute("employees", employeeService.listAll());
        return "employee/employee-list";
    }
    
    @RequestMapping("/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("employee", employeeService.getById(Integer.parseInt(id)));
        return "employee/employee";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Employee employee = employeeService.getById(Integer.parseInt(id));
        EmployeeForm employeeForm = employeeToEmployeeForm.convert(employee);

        model.addAttribute("employeeForm", employeeForm);
        return "employee/employee-form";
    }
    
    @RequestMapping("/new")
    public String newEmployee(Model model){
        model.addAttribute("employeeForm", new EmployeeForm());
        return "employee/employee-form";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(EmployeeForm employeeForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "employee/employee-form";
        }

        Employee savedProduct = employeeService.saveOrUpdateObjectForm(employeeForm);

        return "redirect:/employee/show/" + savedProduct.getId();
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        employeeService.delete(Integer.valueOf(id));
        return "redirect:/employee/list";
    }
}
