package com.alecgavrilovich.procurement.dao;

import java.util.List;

import com.alecgavrilovich.procurement.domain.RFO;

public interface RFODao {

	List<RFO> findAll();
	
	RFO findOne(Integer id);
	
	void save(RFO rfo);
	
	void update(RFO rfo);
	
	void delete(Integer id);
	
}
