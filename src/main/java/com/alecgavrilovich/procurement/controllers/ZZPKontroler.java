package com.alecgavrilovich.procurement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alecgavrilovich.procurement.dbb.ZZPDBB;
import com.alecgavrilovich.procurement.domain.ZZP;

@Controller
@RequestMapping("/zpp")
public class ZZPKontroler {
	
	@Autowired
	private ZZPDBB zzpDBB;
	
	private ZZP zzp = new ZZP();
	
	
	
}
