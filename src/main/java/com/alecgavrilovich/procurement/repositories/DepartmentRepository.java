package com.alecgavrilovich.procurement.repositories;


import java.util.List;
import com.alecgavrilovich.procurement.domain.Department;

public interface DepartmentRepository {
	
	public List<Department> findAll();
	
}
