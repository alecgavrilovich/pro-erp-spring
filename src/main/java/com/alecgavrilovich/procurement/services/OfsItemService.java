package com.alecgavrilovich.procurement.services;

import java.util.List;

import com.alecgavrilovich.procurement.commands.OfsItemForm;
import com.alecgavrilovich.procurement.domain.OfsItem;

public interface OfsItemService extends ProcurementService<OfsItem, OfsItemForm> {
	
	public List<OfsItem> getItemsByOfsId(Integer id);
	
}
