package com.alecgavrilovich.procurement.dbb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.domain.Proizvod;

@Component
public class ProizvodDBB {
	
	public List<Proizvod> pronadjiProizvode() {
		
		List<Proizvod> proizvodi = new ArrayList<>();
		
		try {
			
			Connection connection = DBUtil.getDataSource().getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Proizvod");
			
			while(rs.next()) {
				
				Proizvod pr = new Proizvod();
				pr.setId(rs.getInt("id"));
				pr.setOpisPr(rs.getString("opispr"));
				pr.setJmId(rs.getInt("jmid"));
				proizvodi.add(pr);
				
			}
			
			connection.close();
			
		} catch (Exception e){
			System.out.println(e);
		}
		
		// System.out.println(proizvodi);
		
		return proizvodi;
	}
	
	
	public Proizvod pronadjiPr(int id) {
		
		Proizvod pr = new Proizvod();
		
		try {
			
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Proizvod WHERE ID =?");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				pr.setId(rs.getInt(1));
				pr.setOpisPr(rs.getString(2));
				pr.setJmId(rs.getInt(3));
			}
			
			connection.close();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		return pr;
		
	}
	
	public void sacuvajProizvod(Proizvod pr) {
		
		
		try {
			
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Proizvod VALUES(?, ?, ?)");
			
			ps.setInt(1, pr.getId());
			ps.setString(2, pr.getOpisPr());
			ps.setInt(3, pr.getJmId());
			
			ps.executeQuery();
			
			// nakon izvrsavanja nardbe imamo bool vrednost poziva roll back, commit
			// kontrola nakon transakcijom je kod konrolora
			
			connection.close();
			
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
public void sacuvajIzmene(int id, String opisPr, int JmId) {
		
		
		try {
			
			// String queryString = "UPDATE Proizvod SET opispr = " + id + " + ", set jmid = ? WHERE id = ?";
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE Proizvod SET opispr = ?, set jmid = ? WHERE id = ?");
			
			
			ps.setString(1, opisPr);
			ps.setInt(2, JmId);
			ps.setInt(3, id);
			
			ps.executeQuery();
			
			connection.close();
			
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
	public void izbrisiProizvod(int id) {
		
		try {
			
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Proizvod WHERE ID =?");
			
			ps.setInt(1, id);
			ps.executeQuery();
			
			connection.close();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
	}
}
