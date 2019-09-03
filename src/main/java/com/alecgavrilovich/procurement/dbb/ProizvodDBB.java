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
			ResultSet rs = st.executeQuery("select * from Proizvod");
			
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
	
	public void sacuvajProizvod(Proizvod pr) {
		
		
		try {
			
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Proizvod VALUES(?, ?, ?)");
			
			ps.setInt(1, pr.getId());
			ps.setString(2, pr.getOpisPr());
			ps.setInt(3, pr.getJmId());
			
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
