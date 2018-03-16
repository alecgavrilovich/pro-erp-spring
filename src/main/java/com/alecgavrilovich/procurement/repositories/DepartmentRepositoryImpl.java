package com.alecgavrilovich.procurement.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.alecgavrilovich.procurement.domain.Department;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

	@Override
	public List<Department> findAll() {

		return null;
	}

}
