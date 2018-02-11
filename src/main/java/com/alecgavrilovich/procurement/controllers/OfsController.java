package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alecgavrilovich.procurement.services.OfsItemServiceImpl;
// import com.alecgavrilovich.procurement.converters.OfsToOfsForm;
import com.alecgavrilovich.procurement.services.OfsService;

@Controller
@RequestMapping("/ofs")
public class OfsController {
	
	private OfsService ofsService;
	private OfsItemServiceImpl ofsItemServiceImpl;
//	private OfsToOfsForm ofsToOfsForm;
	
	@Autowired
	public void setOfsService(OfsService ofsService) {
		this.ofsService = ofsService;
	}
	
	@Autowired
	public void setOfsItemServiceImpl(OfsItemServiceImpl ofsItemService) {
		this.ofsItemServiceImpl = ofsItemService;
	}
	
//	@Autowired
//	public void setToOfsForm(OfsToOfsForm ofsToOfsForm) {
//		this.ofsToOfsForm = ofsToOfsForm;
//	}
	
	@RequestMapping("")
	public String redirToList() {
		return "redirect:/ofs/list";
	}
	
	@RequestMapping("/list")
	public String ofsList(ModelMap model) {
		model.addAttribute("ofsList", ofsService.listAll());
		return "ofs/ofs-list";
	}
	
	@RequestMapping("/show/{id}")
	public String showOfs(@PathVariable String id, Model model) {
		Integer ofsId = Integer.valueOf(id);
		model.addAttribute("ofs", ofsService.getById(ofsId));
		model.addAttribute("items", ofsItemServiceImpl.getItemsByOfsId(ofsId));
		return "ofs/ofs";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		ofsService.delete(Integer.valueOf(id));
		return "redirect:/ofs/list";
	}
	
}
