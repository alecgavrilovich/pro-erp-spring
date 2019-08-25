package com.alecgavrilovich.procurement.dao;

import java.util.List;

import com.alecgavrilovich.procurement.domain.Supplier;

public interface SupplierDao {

	List<Supplier> findAll();
	
	Supplier findOne(Integer id);
	
	void save(Supplier supplier);
	
	void update(Supplier supplier);
	
	void delete(Integer id);
}
