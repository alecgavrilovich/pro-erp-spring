package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alecgavrilovich.procurement.services.OfsItemsServiceImpl;
import com.alecgavrilovich.procurement.dao.OFSDao;
// import com.alecgavrilovich.procurement.converters.OfsToOfsForm;
import com.alecgavrilovich.procurement.services.OFSServiceImpl;

@Controller
@RequestMapping("/ofs")
public class OFSController {
	
	private OFSServiceImpl ofsService;
	private OfsItemsServiceImpl ofsItemServiceImpl;
	
	@Autowired
	private OFSDao ofsDao;
	
	@Autowired
	public void setOfsService(OFSServiceImpl ofsService) {
		this.ofsService = ofsService;
	}
	
	@Autowired
	public void setOfsItemServiceImpl(OfsItemsServiceImpl ofsItemService) {
		this.ofsItemServiceImpl = ofsItemService;
	}
	
	
	@RequestMapping("")
	public String redirToList() {
		return "redirect:/ofs/list";
	}
	
	@RequestMapping("/list")
	public String ofsList(Model model) {
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
		ofsDao.delete(Integer.valueOf(id));
		// ofsService.deleteOfs(Integer.valueOf(id));
		return "redirect:/ofs/list";
	}
	
}
