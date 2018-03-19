package com.alecgavrilovich.procurement.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.alecgavrilovich.procurement.dao.RFODao;
import com.alecgavrilovich.procurement.domain.RFO;

@Controller
@RequestMapping("/rfo/edit")
public class EditRFOController {
	
	@Autowired
	private RFODao rfoDao;
	
	@RequestMapping("/{id}")
	public String edit(@PathVariable String id, Model model) {

		RFO rfoForm = rfoDao.findOne(Integer.parseInt(id));
		model.addAttribute("rfoForm", rfoForm);
		
		// List<OFSItem> ofsItems = ofsItemsDao.findByOFSId(Integer.parseInt(id));
		// OFSForm ofsForm = ofsToOFSForm.convert(ofs);
//		List<OFSItemForm> ofsItemsForms = new ArrayList<>();
//		ofsItems.forEach(item -> {
//			OFSItemForm ofsItemForm = ofsItemToOfsItemForm.convert(item);
//			ofsItemForm.setStatus(1);
//			ofsItemsForms.add(ofsItemForm);
//		});
//		ofsForm.setOfsItemsForms(ofsItemsForms);


		return "rfo/edit-rfo-form";
	}
	
	@RequestMapping(value = "/{id}", params = { "saveEdit" })
	public String saveEdit(@ModelAttribute("rfoForm") final RFO rfoForm, final BindingResult bindingResult) {

		rfoDao.update(rfoForm);

		
		// OFS ofs = ofsFormToOFS.convert(ofsForm);
//		ofsForm.getOfsItemsForms().forEach(item -> {
//			OFSItem ofsItem = ofsItemFormToOFSItem.convert(item);
//			switch (item.getStatus()) {
//			case 1:
//				ofsItemsDao.update(ofsItem);
//				break;
//			case 2:
//				ofsItemsDao.delete(ofsItem.getId());
//				break;
//			case 3:
//				ofsItemsDao.save(ofsItem);
//				break;
//			case 4:
//				break;
//			default:
//				break;
//			}
//		});

		return "redirect:/rfo/show/" + rfoForm.getId();

	}
}
