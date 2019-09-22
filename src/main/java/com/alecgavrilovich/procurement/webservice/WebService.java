package com.alecgavrilovich.procurement.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alecgavrilovich.procurement.dbb.ProizvodDBB;
import com.alecgavrilovich.procurement.domain.Proizvod;

@RestController
@RequestMapping("/webService")
public class WebService {
	
	@Autowired
	private ProizvodDBB prDBB;
	

	@RequestMapping("/vratiProizvod/{id}")
	public Proizvod vratiProizvod(@PathVariable("id") int id) {
		
		return prDBB.pronadjiPr(id);
		
	}
	
}
