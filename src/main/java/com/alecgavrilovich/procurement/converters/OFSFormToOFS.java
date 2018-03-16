package com.alecgavrilovich.procurement.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.commands.OFSForm;
import com.alecgavrilovich.procurement.domain.OFS;


@Component
public class OFSFormToOFS implements Converter<OFSForm, OFS> {
	
	@Override
	public OFS convert(OFSForm ofsForm) {
		OFS ofs = new OFS();
		ofs.setId(ofsForm.getId());
		ofs.setOrderDate(ofsForm.getOrderDate());
		ofs.setEmployeeId(ofsForm.getEmployeeId());
		return ofs;
	}
	
}
