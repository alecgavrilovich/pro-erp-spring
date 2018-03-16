package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alecgavrilovich.procurement.commands.OFSForm;
import com.alecgavrilovich.procurement.commands.OFSItemForm;
import com.alecgavrilovich.procurement.dao.OFSDao;
import com.alecgavrilovich.procurement.domain.OFSItem;
import com.alecgavrilovich.procurement.services.OfsService;

@Controller
@RequestMapping("/ofs/new")
public class NewOFSController {

//	@Autowired
//	private OFSDao ofsDao;
	
	@Autowired
	private OfsService ofsService;
	
	@ModelAttribute("ofsForm") 
	public OFSForm newOfsForm() {
		OFSForm ofsForm = new OFSForm();
		return ofsForm;
	}
	
	@RequestMapping("")
	public String newOFS(Model model) {
		return "ofs/new-ofs-form";
	}
	
	@RequestMapping(value="", params={"save"})
	public String sameOFS(OFSForm ofsForm) {
		// this.ofsService.
		return "newofsform";
	}
	
	@RequestMapping(value="", params={"addItem"})
    public String addItem(@ModelAttribute("ofsForm") OFSForm ofsForm, BindingResult bindingResult) {
        ofsForm.getOfsItems().add()
        return "seedstartermng";
    }
	
	
}
