package com.alecgavrilovich.procurement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.commands.OFSForm;
import com.alecgavrilovich.procurement.domain.OFS;

@Component
public class OFSDaoImpl implements OFSDao {

	@Override
	public List<OFS> findAll() {
		
		List<OFS> ofsList = new ArrayList<>();
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM order_for_supplies");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				OFS ofs = new OFS();
				ofs.setId(rs.getInt("ID"));
				ofs.setOrderDate(rs.getDate("ORDER_DATE"));
				ofs.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				ofsList.add(ofs);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ofsList;
	}
	
	@Override
	public OFS findOne(Integer id) {
		
		OFS ofs = new OFS();

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM order_for_supplies WHERE ID =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ofs.setId(rs.getInt("id"));
				ofs.setOrderDate(rs.getDate("order_date"));
				ofs.setEmployeeId(rs.getInt("employee_id"));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return ofs;
	}

	@Override
	public void save(OFSForm ofs) {
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO ORDER_FOR_SUPPLIES VALUES(?, ?, ?)");

			ps.setInt(1, ofs.getId());
			ps.setDate(2, ofs.getOrderDate());
			ps.setInt(3, ofs.getEmployeeId());

			ps.executeQuery();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void update(OFS ofs) {
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE ORDER_FOR_SUPPLIES SET order_date=?, employee_id=? WHERE id=?");

			ps.setDate(1, ofs.getOrderDate());
			ps.setInt(2, ofs.getEmployeeId());
			ps.setInt(3, ofs.getId());

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
			PreparedStatement ps = connection.prepareStatement("DELETE FROM ORDER_FOR_SUPPLIES WHERE ID =?");

			ps.setInt(1, id);

			ps.executeQuery();
			// connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}	

	}

	

}
