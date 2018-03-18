package com.alecgavrilovich.procurement.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.commands.OFSItemForm;
import com.alecgavrilovich.procurement.domain.OFSItem;

@Component
public class OFSItemToOFSItemForm implements Converter<OFSItem, OFSItemForm> {

	@Override
	public OFSItemForm convert(OFSItem ofsItem) {
		
		OFSItemForm ofsItemForm = new OFSItemForm();
		
		ofsItemForm.setOfsId(ofsItem.getOfsId());
		ofsItemForm.setId(ofsItem.getId());
		ofsItemForm.setProductName(ofsItem.getProductName());
		ofsItemForm.setProductId(ofsItem.getProductId());
		ofsItemForm.setOrderDate(ofsItem.getOrderDate());
		ofsItemForm.setQuantity(ofsItem.getQuantity());
		ofsItemForm.setDeliveryTime(ofsItem.getDeliveryTime());
		
		return ofsItemForm;
	}

}
