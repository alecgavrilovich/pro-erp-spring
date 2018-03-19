package com.alecgavrilovich.procurement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.domain.Supplier;

@Component
public class SupplierDaoImpl implements SupplierDao {

	@Override
	public List<Supplier> findAll() {
		
		List<Supplier> suppliersList = new ArrayList<>();

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM SUPPLIER");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Supplier supplier = new Supplier();
				supplier.setId(rs.getInt("ID"));
				supplier.setName(rs.getString("NAME"));
				supplier.setAddress(rs.getString("ADDRESS"));
				supplier.setTelephone(rs.getInt("TELEPHONE"));
				suppliersList.add(supplier);
			}
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return suppliersList;
	}

	@Override
	public Supplier findOne(Integer id) {
		
		Supplier supplier = new Supplier();
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM SUPPLIER WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				supplier.setId(rs.getInt("ID"));
				supplier.setName(rs.getString("NAME"));
				supplier.setAddress(rs.getString("ADDRESS"));
				supplier.setTelephone(rs.getInt("TELEPHONE"));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return supplier;
	}

	@Override
	public void save(Supplier supplier) {
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO SUPPLIER VALUES(?, ?, ?, ?)");

			ps.setInt(1, supplier.getId());
			ps.setString(2, supplier.getName());
			ps.setString(3, supplier.getAddress());
			ps.setInt(4, supplier.getTelephone());

			ps.executeQuery();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void update(Supplier supplier) {
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE SUPPLIER SET NAME=?, ADDRESS=?, TELEPHONE=? WHERE ID=?");

			ps.setString(1, supplier.getName());
			ps.setString(2, supplier.getAddress());
			ps.setInt(3, supplier.getTelephone());
			ps.setInt(4, supplier.getId());

			ps.executeQuery();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void delete(Integer id) {
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM SUPPLIER WHERE id=?");
			ps.setInt(1, id);
			ps.executeQuery();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
