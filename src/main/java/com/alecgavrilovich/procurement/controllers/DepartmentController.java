package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alecgavrilovich.procurement.services.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    
	private DepartmentService departmentService;

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("")
    public String redirToList(){
        return "redirect:department/list";
    }

    @RequestMapping({"/show", "/departments"})
    public String listDepartments(Model model){
        model.addAttribute("departments", departmentService.listAll());
        return "departments";
    }

}
