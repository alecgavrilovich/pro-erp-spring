package com.alecgavrilovich.procurement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.domain.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	
	private static final String UPDATE_QUERY = "UPDATE EMPLOYEE SET UPRN = ?, POSITION = ?, DEPARTMENT_ID = ?, FIRST_NAME = ?, LAST_NAME = ?, SALARY = ? WHERE ID = ?";

	public List<Employee> findAll() {

		List<Employee> employees = new ArrayList<>();

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEE");
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("ID"));
				emp.setUprn(rs.getLong("UPRN"));
				emp.setPosition(rs.getString("POSITION"));
				emp.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				emp.setFirst_name(rs.getString("FIRST_NAME"));
				emp.setLast_name(rs.getString("LAST_NAME"));
				employees.add(emp);
			}
			// connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return employees;
	}

	public Employee findOne(Integer id) {

		Employee emp = new Employee();

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM EMPLOYEE WHERE ID =" + id);
			if (rs.next()) {
				emp.setId(rs.getInt("ID"));
				emp.setUprn(rs.getLong("UPRN"));
				emp.setPosition(rs.getString("POSITION"));
				emp.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				emp.setFirst_name(rs.getString("FIRST_NAME"));
				emp.setLast_name(rs.getString("LAST_NAME"));
				emp.setSalary(rs.getInt("SALARY"));
			}

			// st.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return emp;
	}

	public void save(Employee employee) {

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?, ?, ?, ?)");

			ps.setInt(1, employee.getId());
			ps.setLong(2, employee.getUprn());
			ps.setString(3, employee.getPosition());
			ps.setInt(4, employee.getDepartment_id());
			ps.setString(5, employee.getFirst_name());
			ps.setString(6, employee.getLast_name());
			ps.setInt(7, employee.getSalary());

			ps.executeQuery();
			// connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void update(Employee employee) {
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);

			ps.setLong(1, employee.getUprn());
			ps.setString(2, employee.getPosition());
			ps.setInt(3, employee.getDepartment_id());
			ps.setString(4, employee.getFirst_name());
			ps.setString(5, employee.getLast_name());
			ps.setInt(6, employee.getSalary());
			ps.setInt(7, employee.getId());

			ps.executeQuery();
			// connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(Integer id) {
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE ID =?");

			ps.setInt(1, id);

			ps.executeQuery();
			// connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
}
