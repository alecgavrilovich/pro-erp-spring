package com.alecgavrilovich.procurement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alecgavrilovich.procurement.commands.OFSItemForm;
import com.alecgavrilovich.procurement.dao.OFSItemsDao;
import com.alecgavrilovich.procurement.domain.OFSItem;

@Service
public class OfsItemsServiceImpl implements OfsItemsService {
	
	@Autowired
	private OFSItemsDao ofsItemsDao;

	@Override
	public List<OFSItem> getItemsByOfsId(Integer id) {	
		return ofsItemsDao.findByOFSId(id);
	}

	@Override
	public void saveOFSItem(OFSItem ofsItem) {
		ofsItemsDao.save(ofsItem);
	}

	@Override
	public OFSItem updateOFSItem(OFSItem ofsItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOFSItem(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
