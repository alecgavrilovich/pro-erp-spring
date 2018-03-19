package com.alecgavrilovich.procurement.dao;

import java.util.List;

import com.alecgavrilovich.procurement.domain.RNote;


public interface RNoteDao {
	
	List<RNote> findAll();
	
	RNote findOne(Integer id);
	
	void save(RNote rNote);
	
	void update(RNote rNote);
	
	void delete(Integer id);
}
