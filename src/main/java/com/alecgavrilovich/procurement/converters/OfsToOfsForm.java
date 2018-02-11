package com.alecgavrilovich.procurement.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.commands.OfsForm;
import com.alecgavrilovich.procurement.domain.OrderForSupplies;


@Component
public class OfsToOfsForm implements Converter<OrderForSupplies, OfsForm> {
	
	@Override
	public OfsForm convert(OrderForSupplies ofs) {
		OfsForm ofsForm = new OfsForm();
		ofsForm.setId(ofs.getId());
		ofsForm.setOrderDate(ofs.getOrderDate());
		ofsForm.setEmployeeId(ofs.getEmployeeId());
		return ofsForm;
	}
	
}
