package com.alecgavrilovich.procurement.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.commands.OfsForm;
import com.alecgavrilovich.procurement.domain.OrderForSupplies;


@Component
public class OfsFormToOfs implements Converter<OfsForm, OrderForSupplies> {
	
	@Override
	public OrderForSupplies convert(OfsForm ofsForm) {
		OrderForSupplies ofs = new OrderForSupplies();
		ofs.setId(ofsForm.getId());
		ofs.setOrderDate(ofsForm.getOrderDate());
		ofs.setEmployeeId(ofsForm.getEmployeeId());
		return ofs;
	}
	
}
