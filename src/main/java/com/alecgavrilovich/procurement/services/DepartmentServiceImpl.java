package com.alecgavrilovich.procurement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alecgavrilovich.procurement.dao.DepartmentDao;
import com.alecgavrilovich.procurement.domain.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentDao;

    @Override
    public List<Department> listAll() {
        List<Department> departments = departmentDao.findAll();
        return departments;
    }

}
