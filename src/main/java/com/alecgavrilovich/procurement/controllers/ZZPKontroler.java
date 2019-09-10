package com.alecgavrilovich.procurement.controllers;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alecgavrilovich.procurement.dbb.ZZPDBB;
import com.alecgavrilovich.procurement.domain.StavkaZZP;
import com.alecgavrilovich.procurement.domain.ZZP;


@Controller
@RequestMapping("/zzp")
public class ZZPKontroler {
	
	@Autowired
	private ZZPDBB zzpDBB;
	
	private ZZP zzp = new ZZP();
	
	@RequestMapping("")
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
		
		return "redirect:/zzp";
		
	}
	
	@RequestMapping("/noviZZP")
	public String noviZZP(Model model) {
		
		Integer sifraNovogZZP = zzpDBB.vratiSifruZZP();
		Date datum = new Date(System.currentTimeMillis());
		
		zzp.setSifraZZP(sifraNovogZZP);
		zzp.setDatum(datum);
		
		model.addAttribute("sifraNovogZZP", sifraNovogZZP);
		model.addAttribute("datumZZP", datum);
		
		return "zzp/novi-zzp";
		
	}
	
	@RequestMapping(value="/sacuvajZZP", method = RequestMethod.POST)
	public String sacuvajZZP(@RequestParam("sifraDob") Integer sifraDob) {
		
		zzp.setSifraDob(sifraDob);
		
		zzp.setImeDob("test");
	
		zzp.setVrednostZZP(100);
		
		zzpDBB.sacuvajZZP(zzp);
		
		return "redirect:/zzp";
		
	}
	
}
