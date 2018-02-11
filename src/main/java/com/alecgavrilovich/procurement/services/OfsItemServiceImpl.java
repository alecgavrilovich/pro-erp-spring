package com.alecgavrilovich.procurement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alecgavrilovich.procurement.commands.OfsItemForm;
import com.alecgavrilovich.procurement.domain.OfsItem;
import com.alecgavrilovich.procurement.repositories.OfsItemsRepository;

@Service
public class OfsItemServiceImpl implements OfsItemService {
	
	private OfsItemsRepository ofsItemRepository;

	@Autowired
	public OfsItemServiceImpl(OfsItemsRepository ofsItemRepository) {
		this.ofsItemRepository= ofsItemRepository;
	}
	
	
	@Override
	public List<OfsItem> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfsItem getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfsItem saveOrUpdate(OfsItem targetObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public OfsItem saveOrUpdateObjectForm(OfsItemForm targetObjectForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OfsItem> getItemsByOfsId(Integer id) {
		List<OfsItem> items = new ArrayList<>();
		ofsItemRepository.findByOfsId(id).forEach(items::add);
		return items;
	}

}
