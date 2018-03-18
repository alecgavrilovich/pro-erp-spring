package com.alecgavrilovich.procurement.services;

import java.util.List;

import com.alecgavrilovich.procurement.commands.OFSForm;
import com.alecgavrilovich.procurement.domain.OFS;

public interface OFSService {
	
	List<OFS> listAll();
	
	OFS getById(Integer id);
	
	OFS saveOfs(OFSForm ofsForm);
	
	void updateOfs(OFS ofs);
	
	void deleteOfs(Integer id);

}
