package com.alecgavrilovich.procurement.services;

import java.util.List;

import com.alecgavrilovich.procurement.commands.OFSItemForm;
import com.alecgavrilovich.procurement.domain.OFSItem;

public interface OfsItemService extends ProcurementService<OFSItem, OFSItemForm> {
	
	public List<OFSItem> getItemsByOfsId(Integer id);
	
}
