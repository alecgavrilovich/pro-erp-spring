package com.alecgavrilovich.procurement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

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

		} catch (Exception e) {
			System.out.println(e);
		}

		return ofs;
	}

	@Override
	public void save(OFS ofs) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(OFS ofs) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	

}
