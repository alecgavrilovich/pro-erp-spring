package com.alecgavrilovich.procurement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.alecgavrilovich.procurement.domain.OrderForSupplies;

public interface OfsRepository extends CrudRepository<OrderForSupplies, Integer> {

}
