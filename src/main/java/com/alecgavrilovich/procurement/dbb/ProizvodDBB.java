package com.alecgavrilovich.procurement.dbb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.domain.Proizvod;

@Component
public class ProizvodDBB {
	
	Connection con = null;
	
	public Connection openConnection() {
		
		try {
			
			con = DBUtil.getDataSource().getConnection();
			con.setAutoCommit(false);
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return con;
		
	}
	
	
	public void closeConnection() {
		
		try {
			
			
			con.setAutoCommit(true);
			con.close();
			
		} catch (SQLException e) {
			
			System.out.println(e);
			
		}
		
	}
	
	
	public void commitTransaction() {
		
		try {
			
			con.commit();
			
		} catch (SQLException e) {
			
			System.out.println(e);
			
		}
	}
	
	public void rollBackTransaction() {
		
		try {
			
			con.rollback();
			
		} catch (SQLException e) {
			
			System.out.println(e);
		}
		
	}
	
	
	public List<Proizvod> pronadjiProizvode() {
		
		List<Proizvod> proizvodi = new ArrayList<>();
		
		try {
			
			
			// Connection connection = DBUtil.getDataSource().getConnection();
			
			openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Proizvod");
			
			while(rs.next()) {
				
				Proizvod pr = new Proizvod();
				pr.setId(rs.getInt("id"));
				pr.setOpisPr(rs.getString("opispr"));
				pr.setJmId(rs.getInt("jmid"));
				proizvodi.add(pr);
				
				// System.out.println(pr.getId());
				
			}
			
			closeConnection();
			
		} catch (Exception e){
			System.out.println(e);
		}
		
		return proizvodi;
	}
	
	
	public Proizvod pronadjiPr(int id) {
		
		Proizvod pr = new Proizvod();
		
		try {
			
			openConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Proizvod WHERE ID =?");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				pr.setId(rs.getInt(1));
				pr.setOpisPr(rs.getString(2));
				pr.setJmId(rs.getInt(3));
			}
			
			closeConnection();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return pr;
		
	}
	
	public boolean sacuvajProizvod(Proizvod pr) {
		
		
		boolean ret = false;
		
		try {
			
			openConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Proizvod VALUES(?, ?, ?)");
			
			ps.setInt(1, pr.getId());
			ps.setString(2, pr.getOpisPr());
			ps.setInt(3, pr.getJmId());
			
			ret = ps.executeQuery() != null;
			
			// nakon izvrsavanja nardbe imamo bool vrednost poziva roll back, commit
			// kontrola nakon transakcijom je kod konrolora
			
			
		} catch (SQLException e){
			System.out.println(e);
		}
		
		return ret;
		
	}
	
	public boolean sacuvajIzmene(int id, String opisPr, int JmId) {
		
		
		boolean ret = false;
		
		try {
			
			openConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE Proizvod SET opispr = ?, jmid = ? WHERE id = ?");
			
			ps.setInt(3, id);
			ps.setString(1, opisPr);
			ps.setInt(2, JmId);
			
			
			ret = ps.executeQuery() != null;
			
		} catch (Exception e){
			System.out.println(e);
		}
		
		return ret;
		
	}
	
	public boolean izbrisiProizvod(int id) {
		
		boolean ret = false;
		
		try {
			
			openConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM Proizvod WHERE ID =?");
			
			ps.setInt(1, id);
			ret = ps.executeQuery() != null;
			
			
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return ret;
		
	}
}
