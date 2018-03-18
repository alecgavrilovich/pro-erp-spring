package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alecgavrilovich.procurement.dao.SupplierDao;
import com.alecgavrilovich.procurement.domain.Supplier;

@Controller
@RequestMapping("/suppliers/edit")
public class EditSupplierController {

	@Autowired
	private SupplierDao supplierDao;
	
	@RequestMapping("/{id}")
	public String showSupplier(@PathVariable String id, Model model) {
		model.addAttribute("supplierForm", supplierDao.findOne(Integer.valueOf(id)));
		
		return "supplier/edit-supplier";
		
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveSupplier(Supplier supplierForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "supplier/edit-supplier";
		}

		supplierDao.update(supplierForm);
		return "redirect:/suppliers/show/" + supplierForm.getId();
	}
}
