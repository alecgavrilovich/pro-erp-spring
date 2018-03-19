package com.alecgavrilovich.procurement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.domain.RNote;

@Component
public class RNoteDaoImpl implements RNoteDao {
	
	@Override
	public List<RNote> findAll() {
		
		List<RNote> rNoteList = new ArrayList<>();

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM RECEIVED_NOTE_2");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RNote rNote = new RNote();
				rNote.setId(rs.getInt("ID"));
				rNote.setDateReceived(rs.getDate("date_received"));
				rNote.setEmployeeId(rs.getInt("employee_id"));
				rNote.setSupplierId(rs.getInt("supplier_id"));
				rNote.setDnoteId(rs.getInt("dnote_id"));
				rNote.setDnoteItemId(rs.getInt("dnote_item_id"));
				rNote.setNumPackages(rs.getInt("num_packages"));
				rNote.setInspector(rs.getInt("inspector"));
				rNoteList.add(rNote);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return rNoteList;
	}

	@Override
	public RNote findOne(Integer id) {
		
		RNote rNote = new RNote();
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM RECEIVED_NOTE_2 WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				rNote.setId(rs.getInt("ID"));
				rNote.setDateReceived(rs.getDate("date_received"));
				rNote.setEmployeeId(rs.getInt("employee_id"));
				rNote.setSupplierId(rs.getInt("supplier_id"));
				rNote.setDnoteId(rs.getInt("dnote_id"));
				rNote.setDnoteItemId(rs.getInt("dnote_item_id"));
				rNote.setNumPackages(rs.getInt("num_packages"));
				rNote.setInspector(rs.getInt("inspector"));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return rNote;
	}

	@Override
	public void save(RNote rNote) {
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO RECEIVED_NOTE_2(id, date_received, employee_id, supplier_id, dnote_id, dnote_item_id, num_packages, inspector) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setInt(1, rNote.getId());
			ps.setDate(2, rNote.getDateReceived());
			ps.setInt(3, rNote.getEmployeeId());
			ps.setInt(4, rNote.getSupplierId());
			ps.setInt(5, rNote.getDnoteId());
			ps.setInt(6, rNote.getDnoteItemId());
			ps.setInt(7, rNote.getNumPackages());
			ps.setInt(8, rNote.getInspector());

			ps.executeQuery();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void update(RNote rNote) {
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE RECEIVED_NOTE_2 SET date_received=?, employee_id=?, supplier_id=?, dnote_id=?, dnote_item_id=?, num_packages=?, inspector=? WHERE id=?");

			ps.setDate(1, rNote.getDateReceived());
			ps.setInt(2, rNote.getEmployeeId());
			ps.setInt(3, rNote.getSupplierId());
			ps.setInt(4, rNote.getDnoteId());
			ps.setInt(5, rNote.getDnoteItemId());
			ps.setInt(6, rNote.getNumPackages());
			ps.setInt(7, rNote.getEmployeeId());
			ps.setInt(8, rNote.getId());

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
			PreparedStatement ps = connection.prepareStatement("DELETE FROM RECEIVED_NOTE_BASIC WHERE id=?");
			ps.setInt(1, id);
			ps.executeQuery();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
