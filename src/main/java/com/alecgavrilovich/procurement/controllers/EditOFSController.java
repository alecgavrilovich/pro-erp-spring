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
import com.alecgavrilovich.procurement.repositories.OfsItemsRepository;

@Controller
@RequestMapping("/ofs/edit")
public class EditOFSController {

	@Autowired
	private OFSDao ofsDao;

	@Autowired
	private OFSItemsDao ofsItemsDao;

	@Autowired
	private OfsItemsRepository ofsItemsRepository;

	@Autowired
	private OFSToOFSForm ofsToOFSForm;

	@Autowired
	private OFSFormToOFS ofsFormToOFS;

	@Autowired
	private OFSItemToOFSItemForm ofsItemToOfsItemForm;

	@Autowired
	private OFSItemFormToOFSItem ofsItemFormToOFSItem;

	// private List<OFSItemForm> updatedOFSItems = new ArrayList<>();
	// private List<OFSItemForm> newOfsItems = new ArrayList<>();
	private List<OFSItemForm> deletedOFSItems = new ArrayList<>();

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

		if (this.deletedOFSItems.size() > 0) {
			this.deletedOFSItems.forEach(item -> {
				OFSItem ofsItem = ofsItemFormToOFSItem.convert(item);
				ofsItemsDao.delete(ofsItem.getId());
			});
		}

		ofsForm.getOfsItemsForms().forEach(item -> {
			OFSItem ofsItem = ofsItemFormToOFSItem.convert(item);
			ofsItemsRepository.save(ofsItem);
		});

		return "redirect:/ofs/show/" + ofsForm.getId();

	}

	@RequestMapping(value = "/{id}", params = { "addItemEdit" })
	public String addItem(@ModelAttribute("ofsForm") final OFSForm ofsForm, final BindingResult bindingResult) {

		ofsForm.getOfsItemsForms().add(new OFSItemForm());
		return "ofs/edit-ofs-form";

	}

	@RequestMapping(value = "/{id}", params = { "removeItemEdit" })
	public String removeItem(@ModelAttribute("ofsForm") final OFSForm ofsForm, final BindingResult bindingResult,
			final HttpServletRequest req) {
		Integer itemId = Integer.valueOf(req.getParameter("removeItemEdit"));
		OFSItemForm ofsItemForm = ofsForm.getOfsItemsForms().get(itemId.intValue());
		ofsItemForm.setStatus(2);
		this.deletedOFSItems.add(ofsItemForm);
		
		// if (ofsItemForm.getId() == null) {
		// } else {
		// ofsForm.getOfsItemsForms().get(itemId.intValue()).setStatus(2);
		// }
		//ofsForm.getOfsItemsForms().remove(itemId.intValue());

		return "ofs/edit-ofs-form";
	}

}
