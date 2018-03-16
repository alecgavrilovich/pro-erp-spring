package com.alecgavrilovich.procurement.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alecgavrilovich.procurement.commands.OFSForm;
import com.alecgavrilovich.procurement.converters.OFSFormToOFS;
import com.alecgavrilovich.procurement.dao.OFSDao;
import com.alecgavrilovich.procurement.domain.OFS;
import com.alecgavrilovich.procurement.repositories.OfsRepository;

@Service
public class OfsService implements ProcurementService<OFS, OFSForm> {

	@Autowired
	private OFSDao ofsDao;
	
	//private OfsRepository ofsRepository;
	@SuppressWarnings("unused")
	private OFSFormToOFS ofsFormToOfs;
	
//	@Autowired
//	public OfsService(OfsRepository ofsRepository,
//			OfsFormToOfs ofsFormToOfs
//	) {
//		this.ofsRepository = ofsRepository;
//		 this.ofsFormToOfs = ofsFormToOfs;
//	}
	
	@Override
	public List<OFS> listAll() {
		return ofsDao.findAll();
	}

	@Override
	public OFS getById(Integer id) {
		// OFS ofs = ;
		return ofsDao.findOne(id);
	}

	@Override
	public OFS saveOrUpdate(OFS targetObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// ofsRepository.delete(id);
	}

	@Override
	public OFS saveOrUpdateObjectForm(OFSForm targetObjectForm) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
