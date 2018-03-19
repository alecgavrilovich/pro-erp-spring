package com.alecgavrilovich.procurement.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alecgavrilovich.procurement.commands.OFSForm;
// import com.alecgavrilovich.procurement.converters.OFSFormToOFS;
// import com.alecgavrilovich.procurement.converters.OFSItemFormToOFSItem;
import com.alecgavrilovich.procurement.dao.OFSDao;
//import com.alecgavrilovich.procurement.dao.OFSItemsDao;
import com.alecgavrilovich.procurement.domain.OFS;
// import com.alecgavrilovich.procurement.domain.OFSItem;
// import com.alecgavrilovich.procurement.repositories.OfsRepository;

@Service
public class OFSServiceImpl implements OFSService {

	@Autowired
	private OFSDao ofsDao;
//	@Autowired
//	private OFSItemsDao ofsItemsDao;

	// private OfsRepository ofsRepository;

	//private OFSFormToOFS ofsFormToOfs;

	@Override
	public List<OFS> listAll() {
		return ofsDao.findAll();
	}

	@Override
	public OFS getById(Integer id) {
		return ofsDao.findOne(id);
	}
	
	@Override
	public OFS saveOfs(OFSForm ofsForm) {
//		OFS ofs = ofsFormToOfs.convert(ofsForm);
//		ofsDao.save(ofs);
//		ofsForm.getOfsItems().forEach(item -> { 
//			// OFSItem ofsItem = OFSItemFormToOFSItem.convert(item); 
//			ofsItemsDao.save(item);
//		});

		return null;
	}

	@Override
	public void updateOfs(OFS ofs) {

	}

	@Override
	public void deleteOfs(Integer id) {
		ofsDao.delete(id);
	}


}
