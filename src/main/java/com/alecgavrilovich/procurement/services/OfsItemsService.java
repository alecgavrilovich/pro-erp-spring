package com.alecgavrilovich.procurement.services;

import java.util.List;
import com.alecgavrilovich.procurement.domain.OFSItem;

public interface OfsItemsService {
	
	List<OFSItem> getItemsByOfsId(Integer id);
	
	void saveOFSItem(OFSItem ofsItem);
	
	OFSItem updateOFSItem(OFSItem ofsItem);
	
	void deleteOFSItem(Integer id);
	
}
