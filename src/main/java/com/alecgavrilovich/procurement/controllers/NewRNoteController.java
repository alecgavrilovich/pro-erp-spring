package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alecgavrilovich.procurement.dao.RNoteDao;
import com.alecgavrilovich.procurement.domain.RNote;


@Controller
@RequestMapping("/rnote/new")
public class NewRNoteController {

	@Autowired
	private RNoteDao rnoteDao;
	
	@RequestMapping("")
	public String newEmployee(Model model) {
		model.addAttribute("rnoteForm", new RNote());
		return "rnote/new-rnote-form";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveRNote(@ModelAttribute("rnoteForm") RNote rnoteForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "rnote/new-rnote-form";
		}

		rnoteDao.save(rnoteForm);
		return "redirect:/rnote/show/" + rnoteForm.getId();
	}
}
