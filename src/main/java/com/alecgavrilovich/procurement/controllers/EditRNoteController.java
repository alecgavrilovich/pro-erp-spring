package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alecgavrilovich.procurement.dao.RNoteDao;
import com.alecgavrilovich.procurement.domain.RNote;

@Controller
@RequestMapping("/rnote/edit")
public class EditRNoteController {
	
	@Autowired
	private RNoteDao rnoteDao;

	@RequestMapping("/{id}")
	public String showRNote(@PathVariable String id, Model model) {
		model.addAttribute("rnoteForm", rnoteDao.findOne(Integer.valueOf(id)));

		return "rnote/edit-rnote-form";

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveRNote(RNote rnoteForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "rnote/edit-rnote-form";
		}

		rnoteDao.update(rnoteForm);
		return "redirect:/rnote/show/" + rnoteForm.getId();
	}
}
