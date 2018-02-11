package com.alecgavrilovich.procurement.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alecgavrilovich.procurement.domain.OfsItem;

public interface OfsItemsRepository extends CrudRepository<OfsItem, Integer> {

	public List<OfsItem> findByOfsId(Integer id);
}
