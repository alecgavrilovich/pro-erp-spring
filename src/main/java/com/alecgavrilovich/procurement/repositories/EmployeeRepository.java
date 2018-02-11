package com.alecgavrilovich.procurement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.alecgavrilovich.procurement.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
