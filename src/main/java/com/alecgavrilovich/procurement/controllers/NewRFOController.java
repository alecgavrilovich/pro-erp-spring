package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alecgavrilovich.procurement.dao.RFODao;
import com.alecgavrilovich.procurement.domain.RFO;


@Controller
@RequestMapping("/rfo/new")
public class NewRFOController {
	
	@Autowired
	private RFODao rfoDao;
	
	@RequestMapping("")
	public String newRFO(Model model) {
		model.addAttribute("rfoForm", new RFO());
		return "rfo/new-rfo-form";
	}
	
	@RequestMapping(value="", params={"save"})
	public String saveRFO(@ModelAttribute("rfoForm") RFO rfoForm, BindingResult bindingResult) {
		rfoDao.save(rfoForm);
		return "redirect:/rfo/show/" + rfoForm.getId();
	}
}
