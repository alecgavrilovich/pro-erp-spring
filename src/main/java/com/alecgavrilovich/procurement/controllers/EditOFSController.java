package com.alecgavrilovich.procurement.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alecgavrilovich.procurement.commands.OFSForm;
import com.alecgavrilovich.procurement.commands.OFSItemForm;
import com.alecgavrilovich.procurement.converters.OFSFormToOFS;
import com.alecgavrilovich.procurement.converters.OFSItemFormToOFSItem;
import com.alecgavrilovich.procurement.converters.OFSItemToOFSItemForm;
import com.alecgavrilovich.procurement.converters.OFSToOFSForm;
import com.alecgavrilovich.procurement.dao.OFSDao;
import com.alecgavrilovich.procurement.dao.OFSItemsDao;
import com.alecgavrilovich.procurement.domain.OFS;
import com.alecgavrilovich.procurement.domain.OFSItem;
// import com.alecgavrilovich.procurement.repositories.OfsItemsRepository;

@Controller
@RequestMapping("/ofs/edit")
public class EditOFSController {

	@Autowired
	private OFSDao ofsDao;

	@Autowired
	private OFSItemsDao ofsItemsDao;

//	@Autowired
//	private OfsItemsRepository ofsItemsRepository;

	@Autowired
	private OFSToOFSForm ofsToOFSForm;

	@Autowired
	private OFSFormToOFS ofsFormToOFS;

	@Autowired
	private OFSItemToOFSItemForm ofsItemToOfsItemForm;

	@Autowired
	private OFSItemFormToOFSItem ofsItemFormToOFSItem;

	@RequestMapping("/{id}")
	public String edit(@PathVariable String id, Model model) {

		OFS ofs = ofsDao.findOne(Integer.parseInt(id));
		List<OFSItem> ofsItems = ofsItemsDao.findByOFSId(Integer.parseInt(id));

		OFSForm ofsForm = ofsToOFSForm.convert(ofs);
		List<OFSItemForm> ofsItemsForms = new ArrayList<>();
		ofsItems.forEach(item -> {
			OFSItemForm ofsItemForm = ofsItemToOfsItemForm.convert(item);
			ofsItemForm.setStatus(1);
			ofsItemsForms.add(ofsItemForm);
		});

		ofsForm.setOfsItemsForms(ofsItemsForms);

		model.addAttribute("ofsForm", ofsForm);

		return "ofs/edit-ofs-form";
	}

	@RequestMapping(value = "/{id}", params = { "saveEdit" })
	public String saveEdit(@ModelAttribute("ofsForm") final OFSForm ofsForm, final BindingResult bindingResult) {

		OFS ofs = ofsFormToOFS.convert(ofsForm);
		
		ofsDao.update(ofs);
		
		ofsForm.getOfsItemsForms().forEach(item -> {
			
			OFSItem ofsItem = ofsItemFormToOFSItem.convert(item);
			switch (item.getStatus()) {
			case 1:
				ofsItemsDao.update(ofsItem);
				break;
			case 2:
				ofsItemsDao.delete(ofsItem.getId());
				break;
			case 3:
				ofsItemsDao.save(ofsItem);
				break;
			case 4:
				break;
			default:
				break;
			}
		});

		return "redirect:/ofs/show/" + ofsForm.getId();

	}

	@RequestMapping(value = "/{id}", params = { "addItemEdit" })
	public String addItem(@ModelAttribute("ofsForm") final OFSForm ofsForm, final BindingResult bindingResult) {
		OFSItemForm ofsItemForm = new OFSItemForm();
		ofsItemForm.setStatus(3);
		ofsForm.getOfsItemsForms().add(ofsItemForm);
		return "ofs/edit-ofs-form";

	}

	@RequestMapping(value = "/{id}", params = { "removeItemEdit" })
	public String removeItem(@ModelAttribute("ofsForm") final OFSForm ofsForm, final BindingResult bindingResult,
			final HttpServletRequest req) {
		Integer itemId = Integer.valueOf(req.getParameter("removeItemEdit"));
		OFSItemForm ofsItemForm = ofsForm.getOfsItemsForms().get(itemId.intValue());

		switch (ofsItemForm.getStatus()) {
		case 1:
			ofsItemForm.setStatus(2);
			break;
		case 3:
			ofsItemForm.setStatus(4);
			break;
		case 2:
			ofsItemForm.setStatus(1);
			break;
		case 4:
			ofsItemForm.setStatus(3);
			break;
		default:
			break;
		}
		
//		if (ofsItemForm.getStatus() == 1) {
//			ofsItemForm.setStatus(2);
//		} else if (ofsItemForm.getStatus() == 3) {
//			ofsItemForm.setStatus(4);
//		}

		return "ofs/edit-ofs-form";
	}

}
