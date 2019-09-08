package com.alecgavrilovich.procurement.dbb;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.alecgavrilovich.procurement.domain.ZZP;
import com.alecgavrilovich.procurement.repositories.StavkaZZPRepo;
import com.alecgavrilovich.procurement.repositories.ZZPRepo;

@Component
public class ZZPDBB {
	
	private ZZPRepo zzpRepo;
	
//	@Autowired
//	private StavkaZZPRepo stZZPRepo;
	
	@Autowired
	public ZZPDBB (ZZPRepo zzpRepo) {
		
		this.zzpRepo = zzpRepo;
	}
	
	
	public List<ZZP> pronadjiZZP() {
		
		List<ZZP> listaZZP = new ArrayList<>();
		
		zzpRepo.findAll().forEach(listaZZP::add);
		
		return listaZZP;
		
	}
	

}
