package com.alecgavrilovich.procurement.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alecgavrilovich.procurement.domain.OFSItem;

public interface OfsItemsRepository extends CrudRepository<OFSItem, Integer> {

	public List<OFSItem> findByOfsId(Integer id);

}
