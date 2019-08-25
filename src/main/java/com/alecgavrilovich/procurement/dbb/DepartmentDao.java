package com.alecgavrilovich.procurement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alecgavrilovich.procurement.domain.Department;


@Repository
public class DepartmentDao {

	public List<Department> findAll() {

		List<Department> departments = new ArrayList<>();

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			Statement st = connection.createStatement();
			ResultSet rs =  st.executeQuery("select * from department");
			while (rs.next()) {
				Department dept = new Department();
				dept.setId(rs.getInt("id"));
				dept.setName(rs.getString("name"));
				dept.setEmployee_count(rs.getInt("employee_count"));
				departments.add(dept);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return departments;
	}
}
