package com.alecgavrilovich.procurement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alecgavrilovich.procurement.commands.OfsForm;
import com.alecgavrilovich.procurement.converters.OfsFormToOfs;
import com.alecgavrilovich.procurement.domain.OrderForSupplies;
import com.alecgavrilovich.procurement.repositories.OfsRepository;

@Service
public class OfsService implements ProcurementService<OrderForSupplies, OfsForm> {

	private OfsRepository ofsRepository;
	@SuppressWarnings("unused")
	private OfsFormToOfs ofsFormToOfs;
	
	@Autowired
	public OfsService(OfsRepository ofsRepository,
			OfsFormToOfs ofsFormToOfs
	) {
		this.ofsRepository = ofsRepository;
		 this.ofsFormToOfs = ofsFormToOfs;
	}
	
	@Override
	public List<OrderForSupplies> listAll() {
		List<OrderForSupplies> ofsList = new ArrayList<>();
		ofsRepository.findAll().forEach(ofsList::add);
		return ofsList;
	}

	@Override
	public OrderForSupplies getById(Integer id) {
		OrderForSupplies ofs = ofsRepository.findOne(id);
		return ofs;
	}

	@Override
	public OrderForSupplies saveOrUpdate(OrderForSupplies targetObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		ofsRepository.delete(id);
	}

	@Override
	public OrderForSupplies saveOrUpdateObjectForm(OfsForm targetObjectForm) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
