package com.alecgavrilovich.procurement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.alecgavrilovich.procurement.dbb.ProizvodDBB;
import com.alecgavrilovich.procurement.domain.Proizvod;

@Controller
@RequestMapping("/proizvod")
public class ProizvodKontroler {
	
	@Autowired
	ProizvodDBB prDBB;
	
	Proizvod pr = new Proizvod();
	
	@RequestMapping("/lista")
	public String pronadjiProizvode(Model model) {
		
		List<Proizvod> proizvodi = prDBB.pronadjiProizvode();
		
		model.addAttribute("proizvodi", proizvodi);
		
		return "proizvod/lista-proizvoda";
	}
	
	@RequestMapping("/detalji/{id}")
	public String pronadjiProizvod(@PathVariable int id, Model model) {
		
		Proizvod trazeniPr = prDBB.pronadjiPr(id);
		
		model.addAttribute("pr", trazeniPr);
		
		return "/proizvod/detalji-proizvod";
		
	}
	
	@RequestMapping("/noviProizvod")
	public String noviProizvod() {
		
		return "proizvod/novi-proizvod";
		
	}
	
	@RequestMapping(value="/sacuvajProizvod", method = RequestMethod.POST)
	public String sacuvajProizvod(@RequestParam("id") int id, @RequestParam("opisPr") String opisPr, @RequestParam("JmId") int JmId) {
		
		boolean ret = false;
		
		pr.setId(id);
		pr.setOpisPr(opisPr);
		pr.setJmId(JmId);
		
		ret = prDBB.sacuvajProizvod(pr);
		
		if (ret) {
			
			prDBB.commitTransaction();
			
		} else {
			
			prDBB.rollBackTransaction();
		}
		
		prDBB.closeConnection();
		
		return "redirect:/proizvod/lista";
	}
	
	
	
	
	@RequestMapping("/izmeni/{id}")
	public String izmeni(@PathVariable int id, Model model) {
		
		Proizvod prZaIzmenu = prDBB.pronadjiPr(id);
		
		model.addAttribute("prIzmena", prZaIzmenu);
		
		return "/proizvod/izmeni-proizvod";
		
	}
	
	@RequestMapping(value="/sacuvajIzmene", method = RequestMethod.POST)
	public String sacuvajIzmene(@RequestParam("id") int id, @RequestParam("opisPr") String opisPr, @RequestParam("JmId") int JmId) {
		
		boolean ret = false;
		
		ret = prDBB.sacuvajIzmene(id, opisPr, JmId);
		
		if (ret) {
			

			prDBB.commitTransaction();
			
		} else {
			
			prDBB.rollBackTransaction();
		}
		
		prDBB.closeConnection();
		
		return "redirect:/proizvod/lista";
		
	}
	
	
	@RequestMapping(value="/izbrisi/{id}")
	public String izbrisiProizvod(@PathVariable int id) {
		
		boolean ret = false;
		
		ret = prDBB.izbrisiProizvod(id);
		
		if (ret) {
			
			prDBB.commitTransaction();
			
		} else {
			
			prDBB.rollBackTransaction();
		}
		
		prDBB.closeConnection();
		
		
		return "redirect:/proizvod/lista";
	}	
		
}
