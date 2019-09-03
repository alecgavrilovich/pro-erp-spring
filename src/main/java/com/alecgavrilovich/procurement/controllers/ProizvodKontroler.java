package com.alecgavrilovich.procurement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@RequestMapping("/noviProizvod")
	public String noviProizvod(Model model) {
		
		model.addAttribute("prForma", pr);
		// model.addAttribute("listJM", prDBB.vratiJM());
		
		return "proizvod/novi-proizvod";
		
	}
	
//	@RequestMapping(value="/sacuvajProizvod", method = RequestMethod.POST)
//	public String sacuvajProizvod(@RequestParam("id") int id, @RequestParam("opisPr") String opisPr, @RequestParam("JmId") int JmId) {
//		
////		if(bindingResult.hasErrors()){
////            return "proizvod/novi-proizvod";
////        }
//		
//		pr.setId(id);
//		pr.setOpisPr(opisPr);
//		pr.setJmId(JmId);
//		
//		prDBB.sacuvajProizvod(pr);
//		
//		
//		return "redirect:/proizvod/lista";
//	}
	
	@RequestMapping(value="/sacuvajProizvod", method = RequestMethod.POST)
	public String sacuvajProizvod(Proizvod pr, BindingResult  bindingResult) {
		
		if(bindingResult.hasErrors()){
            return "proizvod/novi-proizvod";
        }
		
		pr.setId(pr.getId());
		pr.setOpisPr(pr.getOpisPr());
		pr.setJmId(pr.getJmId());
		
		prDBB.sacuvajProizvod(pr);
		
		
		return "redirect:/proizvod/lista";
	}
	
	
	@RequestMapping(value="/izbrisi/{id}")
	public String izbrisiProizvod(@PathVariable int id) {
		
		prDBB.izbrisiProizvod(id);
		
		return "redirect:/proizvod/lista";
	}
	
	
}
