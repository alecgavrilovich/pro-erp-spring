package com.alecgavrilovich.procurement.dbb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.domain.Dobavljac;
import com.alecgavrilovich.procurement.domain.StavkaZZP;
import com.alecgavrilovich.procurement.domain.StavkaZZPId;
import com.alecgavrilovich.procurement.domain.Valuta;
import com.alecgavrilovich.procurement.domain.ZZP;
import com.alecgavrilovich.procurement.repositories.IDobavljacRepo;
import com.alecgavrilovich.procurement.repositories.IStavkaZZPRepo;
import com.alecgavrilovich.procurement.repositories.IValutaRepo;
import com.alecgavrilovich.procurement.repositories.IZZPRepo;

@Component
@Transactional
public class ZZPDBB {
	
	private IZZPRepo zzpRepo;
	private IStavkaZZPRepo stZZPRepo;
	private IValutaRepo valutaRepo;
	private IDobavljacRepo dobavljacRepo;
	Connection con = null;
	
	@Autowired
	public ZZPDBB (IZZPRepo zzpRepo, IStavkaZZPRepo stZZPRepo, IValutaRepo valutaRepo, IDobavljacRepo dobavljacRepo) {
		
		this.zzpRepo = zzpRepo;
		this.stZZPRepo = stZZPRepo;
		this.valutaRepo = valutaRepo;
		this.dobavljacRepo = dobavljacRepo;
	}
	
	
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
	
	
	
	public List<ZZP> pronadjiSveZZP() {
		
		List<ZZP> listaZZP = new ArrayList<>();
		
		zzpRepo.findAll().forEach(listaZZP::add);
		
		return listaZZP;
		
	}
	
	
	
	public ZZP pronadjiZZP(Integer sifraZZP) {
		
		ZZP trazeniZZP = zzpRepo.findOne(sifraZZP);
		
		List<StavkaZZP> stavkeSve = new ArrayList<>();
		List<StavkaZZP> stavkeTrazenogZZP = new ArrayList<>();
				
		stZZPRepo.findAll().forEach(stavkeSve::add);
		
		stavkeSve.forEach((st) -> {
			
			if ((int)st.getSifraZZP() == (int)sifraZZP) {
				
				// st.setStatus(1);
				
				stavkeTrazenogZZP.add(st);
			}
		});
		
		trazeniZZP.setStavke(stavkeTrazenogZZP);
		
		return trazeniZZP;
	}
	
	
	public Integer vratiSifruZZP() {
		
		Integer sifraNovogZZP = null;
		
		try {
			
			openConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT zzp_seq.nextval FROM dual");
			
			if (rs.next()) {
				
				sifraNovogZZP = rs.getInt(1);
				
			}
			
			closeConnection();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return sifraNovogZZP;
		
	}
	
	public void sacuvajZZP(ZZP zzp) {
		
		zzpRepo.save(zzp);
		
		zzp.getStavke().forEach((st) -> {
			
			st.setStatus(1);
			
			stZZPRepo.save(st);
			
		});
		
	}
	
	public void sacuvajIzmene(ZZP zzp) {
		
		List<StavkaZZP> stavkeZZP = zzp.getStavke();
		
		zzpRepo.save(zzp);
		
		stavkeZZP.forEach((st) -> {
			
			int status = st.getStatus();
			
			StavkaZZPId stZZPId = new StavkaZZPId();
			
			stZZPId.setSifraZZP(st.getSifraZZP());
			stZZPId.setRedniBr(st.getRedniBr());
			
			switch (status) {
			
				case 0:
					stZZPRepo.save(st);
					break;
				
				case 1:
					break;
					
				case 2:
					st.setStatus(1);
					stZZPRepo.save(st);
					break;
					
				case 3:
					stZZPRepo.delete(stZZPId);
					break;
					
				default:
					break;
			
			}
			
		});
		
	}
	
	
	public void izbrisiZZP(Integer sifraZZP) {
		
		zzpRepo.delete(sifraZZP);
		
	}
	
	public List<Valuta> vratiValute() {
		
		List<Valuta> listaValuta = new ArrayList<>();
		
		valutaRepo.findAll().forEach(listaValuta::add);
		
		return listaValuta;
		
	}


	public List<Dobavljac> vratiDobavljace() {
		
		List<Dobavljac> listaDobavljaca = new ArrayList<>();
		
		dobavljacRepo.findAll().forEach(listaDobavljaca::add);
		
		return listaDobavljaca;
	}

}
