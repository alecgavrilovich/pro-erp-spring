package com.alecgavrilovich.procurement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alecgavrilovich.procurement.commands.OFSItemForm;
import com.alecgavrilovich.procurement.dao.OFSItemsDao;
import com.alecgavrilovich.procurement.domain.OFSItem;

@Service
public class OfsItemServiceImpl implements OfsItemService {
	
	@Autowired
	private OFSItemsDao ofsItemsDao;
	
	@Override
	public List<OFSItem> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OFSItem getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OFSItem saveOrUpdate(OFSItem targetObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public OFSItem saveOrUpdateObjectForm(OFSItemForm targetObjectForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OFSItem> getItemsByOfsId(Integer id) {
//		List<OFSItem> items = new ArrayList<>();
//		ofsItemRepository.findByOfsId(id).forEach(items::add);	
		return ofsItemsDao.findByOFSId(id);
	}

}
