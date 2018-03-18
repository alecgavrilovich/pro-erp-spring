package com.alecgavrilovich.procurement.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alecgavrilovich.procurement.commands.OFSForm;
import com.alecgavrilovich.procurement.commands.OFSItemForm;
import com.alecgavrilovich.procurement.converters.OFSItemFormToOFSItem;
import com.alecgavrilovich.procurement.dao.OFSDao;
import com.alecgavrilovich.procurement.dao.OFSItemsDao;
import com.alecgavrilovich.procurement.domain.OFSItem;

@Controller
@RequestMapping("/ofs/new")
public class NewOFSController {
	
	@Autowired
	private OFSItemsDao ofsItemsDao;
	
	@Autowired
	private OFSDao ofsDao;
	
	@Autowired
	private OFSItemFormToOFSItem ofsItemFormToOFSItem;
	
	@RequestMapping("")
	public String newOFS(Model model) {
		model.addAttribute("ofsForm", new OFSForm());
		return "ofs/new-ofs-form";
	}
	
	@RequestMapping(value="", params={"save"})
	public String saveOFS(@ModelAttribute("ofsForm") OFSForm ofsForm, BindingResult bindingResult) {
		ofsDao.save(ofsForm); 
		ofsForm.getOfsItemsForms().forEach(item -> {
			OFSItem ofsItem = ofsItemFormToOFSItem.convert(item);
			ofsItemsDao.save(ofsItem);
		});
		return "redirect:/ofs/show/" + ofsForm.getId();
	}
	
	@RequestMapping(value="", params={"addItem"})
    public String addItem(@ModelAttribute("ofsForm") OFSForm ofsForm, BindingResult bindingResult) {
        ofsForm.getOfsItemsForms().add(new OFSItemForm());
        return "ofs/new-ofs-form";
    }
	
	@RequestMapping(value="", params={"removeItem"})
    public String removeItem(@ModelAttribute("ofsForm") OFSForm ofsForm, BindingResult bindingResult, HttpServletRequest req) {
		 Integer itemId = Integer.valueOf(req.getParameter("removeItem"));
		 System.out.println(ofsForm);
		ofsForm.getOfsItemsForms().remove(itemId.intValue());
        return "ofs/new-ofs-form";
    }
	
	
}
