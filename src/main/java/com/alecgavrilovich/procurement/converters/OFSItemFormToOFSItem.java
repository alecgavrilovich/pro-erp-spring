package com.alecgavrilovich.procurement.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.commands.OFSItemForm;
import com.alecgavrilovich.procurement.domain.OFSItem;

@Component
public class OFSItemFormToOFSItem implements Converter<OFSItemForm, OFSItem> {

	@Override
	public OFSItem convert(OFSItemForm ofsItemForm) {
		
		OFSItem ofsItem = new OFSItem();
		
		ofsItem.setOfsId(ofsItemForm.getOfsId());
		ofsItem.setId(ofsItemForm.getId());
		ofsItem.setProductName(ofsItemForm.getProductName());
		ofsItem.setProductId(ofsItemForm.getProductId());
		ofsItem.setQuantity(ofsItemForm.getQuantity());
		ofsItem.setOrderDate(ofsItemForm.getOrderDate());
		ofsItem.setDeliveryTime(ofsItemForm.getDeliveryTime());
		
		return ofsItem;
	}

}
