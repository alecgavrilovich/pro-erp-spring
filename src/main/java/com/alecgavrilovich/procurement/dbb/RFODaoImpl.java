package com.alecgavrilovich.procurement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.alecgavrilovich.procurement.domain.RFO;

@Component
public class RFODaoImpl implements RFODao {

	@Override
	public List<RFO> findAll() {
		List<RFO> rfoList = new ArrayList<>();

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM REQUEST_FOR_OFFER");
			while (rs.next()) {
				RFO rfo = new RFO();
				rfo.setId(rs.getInt("ID"));
				rfo.setDateCreated(rs.getDate("date_created"));
				rfo.setOfsId(rs.getInt("ofs_id"));
				rfo.setSupplierId(rs.getInt("supplier_id"));
				rfo.setSupplierName(rs.getString("supplier_name"));
				rfo.setEmployeeId(rs.getInt("employee_id"));
				rfoList.add(rfo);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return rfoList;
	}

	@Override
	public RFO findOne(Integer id) {
		
		RFO rfo = new RFO();

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM request_for_offer WHERE ID =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rfo.setId(rs.getInt("id"));
				rfo.setDateCreated(rs.getDate("date_created"));
				rfo.setOfsId(rs.getInt("ofs_id"));
				rfo.setSupplierId(rs.getInt("supplier_id"));
				rfo.setSupplierName(rs.getString("supplier_name"));
				rfo.setEmployeeId(rs.getInt("employee_id"));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return rfo;
	}

	@Override
	public void save(RFO rfo) {
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO request_for_offer VALUES(?, ?, ?, ?, ?, ?)");

			ps.setInt(1, rfo.getId());
			ps.setDate(2, rfo.getDateCreated());
			ps.setInt(3, rfo.getOfsId());
			ps.setInt(4, rfo.getSupplierId());
			ps.setString(5, rfo.getSupplierName());
			ps.setInt(6, rfo.getEmployeeId());

			ps.executeQuery();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void update(RFO rfo) {
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE request_for_offer SET date_created=?, ofs_id=?, supplier_id=?, employee_id=? WHERE id=?");

			ps.setDate(1, rfo.getDateCreated());
			ps.setInt(2, rfo.getOfsId());
			ps.setInt(3, rfo.getSupplierId());
			ps.setInt(4, rfo.getEmployeeId());
			ps.setInt(5, rfo.getId());

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
			PreparedStatement ps = connection.prepareStatement("DELETE FROM request_for_offer WHERE ID =?");

			ps.setInt(1, id);

			ps.executeQuery();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
