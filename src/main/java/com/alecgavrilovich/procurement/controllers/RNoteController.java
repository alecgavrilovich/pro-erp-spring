package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alecgavrilovich.procurement.dao.RNoteDao;

@Controller
@RequestMapping("/rnote")
public class RNoteController {
	
	@Autowired
	RNoteDao rNoteDao;

	@RequestMapping("/list")
	public String showAllRNotes(Model model) {
		model.addAttribute("rNoteList", rNoteDao.findAll());
		return "rnote/rnote-list";
	}
	
	@RequestMapping("/show/{id}")
	public String showRNotes(@PathVariable String id, Model model) {
		model.addAttribute("rnote", rNoteDao.findOne(Integer.valueOf(id)));
		return "rnote/rnote";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteRNotes(@PathVariable String id, Model model) {
		rNoteDao.delete(Integer.valueOf(id));
		return "redirect:/rnote/list";
	}
}
