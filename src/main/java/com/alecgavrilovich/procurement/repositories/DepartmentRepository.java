package com.alecgavrilovich.procurement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.alecgavrilovich.procurement.domain.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
	
}
