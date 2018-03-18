package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alecgavrilovich.procurement.dao.SupplierDao;
import com.alecgavrilovich.procurement.domain.Supplier;

@Controller
@RequestMapping("/suppliers/new")
public class NewSupplierController {

	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("")
	public String newSupplier(Model model) {
		model.addAttribute("supplierForm", new Supplier());
		return "supplier/new-supplier";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveSupplier(Supplier supplierForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "supplier/new-supplier";
		}

		supplierDao.save(supplierForm);
		return "redirect:/suppliers/show/" + supplierForm.getId();
	}
}
