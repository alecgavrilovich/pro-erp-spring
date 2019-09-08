package com.alecgavrilovich.procurement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alecgavrilovich.procurement.dbb.ZZPDBB;
import com.alecgavrilovich.procurement.domain.StavkaZZP;
import com.alecgavrilovich.procurement.domain.ZZP;


@Controller
@RequestMapping("/zzp")
public class ZZPKontroler {
	
	@Autowired
	private ZZPDBB zzpDBB;
	
	private ZZP zzp = new ZZP();
	
	@RequestMapping("/")
	public String pronadjiSveZZP(Model model) {
		
		model.addAttribute("listaZZP", zzpDBB.pronadjiSveZZP());
		
		return "zzp/lista-zzp";
		
	}
	
	@RequestMapping("/pronadjiZZP/{sifraZZP}")
	public String pronadjiZZP(@PathVariable("sifraZZP") Integer sifraZZP, Model model) {
	
		ZZP trazeniZZP = zzpDBB.pronadjiZZP(sifraZZP);
		
		List<StavkaZZP> stavke = trazeniZZP.getStavke();
		
		model.addAttribute("zzp", trazeniZZP);
		model.addAttribute("stavke", stavke);
		
		return "zzp/detalji-zzp";
	}
	
	@RequestMapping("/izbrisiZZP/{sifraZZP}")
	public String izbrisiZZP(@PathVariable("sifraZZP") Integer sifraZZP) {
		
		zzpDBB.izbrisiZZP(sifraZZP);
		
		return "redirect:/zzp/";
		
	}
	
	
}
