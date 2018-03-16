package com.alecgavrilovich.procurement.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.commands.OFSForm;
import com.alecgavrilovich.procurement.domain.OFS;


@Component
public class OFSToOFSForm implements Converter<OFS, OFSForm> {
	
	@Override
	public OFSForm convert(OFS ofs) {
		OFSForm ofsForm = new OFSForm();
		ofsForm.setId(ofs.getId());
		ofsForm.setOrderDate(ofs.getOrderDate());
		ofsForm.setEmployeeId(ofs.getEmployeeId());
		return ofsForm;
	}
	
}
