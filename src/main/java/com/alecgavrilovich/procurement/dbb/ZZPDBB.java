package com.alecgavrilovich.procurement.dbb;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.domain.StavkaZZP;
import com.alecgavrilovich.procurement.domain.ZZP;
import com.alecgavrilovich.procurement.repositories.IStavkaZZPRepo;
import com.alecgavrilovich.procurement.repositories.IZZPRepo;

@Component
public class ZZPDBB {
	
	private IZZPRepo zzpRepo;
	private IStavkaZZPRepo stZZPRepo;
	
	@Autowired
	public ZZPDBB (IZZPRepo zzpRepo, IStavkaZZPRepo stZZPRepo) {
		
		this.zzpRepo = zzpRepo;
		this.stZZPRepo = stZZPRepo;
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
				
				stavkeTrazenogZZP.add(st);
			}
		});
		
		trazeniZZP.setStavke(stavkeTrazenogZZP);
		
		return trazeniZZP;
	}
	
	
	public void izbrisiZZP(Integer sifraZZP) {
		
		zzpRepo.delete(sifraZZP);
		
	}

}
