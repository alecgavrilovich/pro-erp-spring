package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alecgavrilovich.procurement.dbb.ZZPDBB;
import com.alecgavrilovich.procurement.domain.ZZP;


@Controller
@RequestMapping("/zzp")
public class ZZPKontroler {
	
	@Autowired
	private ZZPDBB zzpDBB;
	
	private ZZP zzp = new ZZP();
	
	@RequestMapping("/")
	public String pronadjiZZP(Model model) {
		
		model.addAttribute("listaZZP", zzpDBB.pronadjiZZP());
		
		return "zzp/lista-zzp";
		
	}
	
}
