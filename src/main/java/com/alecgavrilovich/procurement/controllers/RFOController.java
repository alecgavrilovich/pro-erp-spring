package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alecgavrilovich.procurement.dao.RFODao;

@Controller
@RequestMapping("/rfo")
public class RFOController {
	
	@Autowired
	private RFODao rfoDao;
	
	@RequestMapping("")
	public String redirToList() {
		return "redirect:/rfo/list";
	}
	
	@RequestMapping("/list")
	public String rfoList(Model model) {
		model.addAttribute("rfoList", rfoDao.findAll());
		return "rfo/rfo-list";
	}
	
	@RequestMapping("/show/{id}")
	public String showRfo(@PathVariable String id, Model model) {
		Integer rfoId = Integer.valueOf(id);
		model.addAttribute("rfo", rfoDao.findOne(rfoId));
		// model.addAttribute("items", rfoItemsDao.getItemsByOfsId(rfoId));
		return "rfo/rfo";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		rfoDao.delete(Integer.valueOf(id));
		return "redirect:/rfo/list";
	}
	
}
