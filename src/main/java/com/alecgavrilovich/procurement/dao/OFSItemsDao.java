package com.alecgavrilovich.procurement.dao;

import java.util.List;

import com.alecgavrilovich.procurement.domain.OFSItem;

public interface OFSItemsDao {

	List<OFSItem> findByOFSId(Integer ofsId);
	
	void save(OFSItem ofsItem);
	
	void update(OFSItem ofsItem);
	
	void delete(Integer id);
}
