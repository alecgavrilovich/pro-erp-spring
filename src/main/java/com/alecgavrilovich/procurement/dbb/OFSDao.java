package com.alecgavrilovich.procurement.dao;

import java.util.List;

import com.alecgavrilovich.procurement.commands.OFSForm;
import com.alecgavrilovich.procurement.domain.OFS;

public interface OFSDao {

	List<OFS> findAll();
	
	OFS findOne(Integer id);
	
	void save(OFSForm ofs);
	
	void update(OFS ofs);
	
	void delete(Integer id);
}
