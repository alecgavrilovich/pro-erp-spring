package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alecgavrilovich.procurement.dao.SupplierDao;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {
	
	@Autowired
	SupplierDao supplierDao;

	@RequestMapping("/list")
	public String showAllSuppliers(Model model) {
		model.addAttribute("suppliers", supplierDao.findAll());
		return "supplier/list";
	}
	
	@RequestMapping("/show/{id}")
	public String showSupplier(@PathVariable String id, Model model) {
		model.addAttribute("supplier", supplierDao.findOne(Integer.valueOf(id)));
		return "supplier/supplier";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteSupplier(@PathVariable String id, Model model) {
		supplierDao.delete(Integer.valueOf(id));
		return "redirect:/suppliers/list";
	}
	
}
