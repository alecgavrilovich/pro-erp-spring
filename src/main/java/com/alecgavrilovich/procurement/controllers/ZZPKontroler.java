package com.alecgavrilovich.procurement.controllers;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alecgavrilovich.procurement.dbb.ProizvodDBB;
import com.alecgavrilovich.procurement.dbb.ZZPDBB;
import com.alecgavrilovich.procurement.domain.Proizvod;
import com.alecgavrilovich.procurement.domain.StavkaZZP;
import com.alecgavrilovich.procurement.domain.Valuta;
import com.alecgavrilovich.procurement.domain.ZZP;
import java.math.BigDecimal;
import java.math.RoundingMode;


@Controller
@RequestMapping("/zzp")
public class ZZPKontroler {
	
	@Autowired
	private ZZPDBB zzpDBB;
	@Autowired
	private ProizvodDBB prDBB;
	private ZZP zzp = new ZZP();
	private List<StavkaZZP> stavkeNovogZZP = new ArrayList<>();
	private int redniBroj = 0;
	
	
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
		
		List<Proizvod> listaProizvoda = prDBB.pronadjiProizvode();
		List<Valuta> listaValuta = zzpDBB.vratiValute();
		
		zzp.setSifraZZP(sifraNovogZZP);
		zzp.setDatum(datum);
		
		model.addAttribute("sifraNovogZZP", sifraNovogZZP);
		model.addAttribute("datumZZP", datum);
		model.addAttribute("listaProizvoda", listaProizvoda);
		model.addAttribute("listaValuta", listaValuta);
		
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
	

	@RequestMapping(value="/dodajStavku", method = RequestMethod.POST)
	public String dodajStavku(HttpServletRequest req, Model model) {
		
		StavkaZZP novaStavka = new StavkaZZP();
		double vrednostNoveStavke;
		double cenaPoKomadu;
		
		int sifraPr = Integer.valueOf(req.getParameter("sifraPr"));
		int kolicina = Integer.valueOf(req.getParameter("kolicina"));
		int cena = Integer.valueOf(req.getParameter("cena"));
		int cenaZaKom = Integer.valueOf(req.getParameter("cenaZaKom"));
		String valuta = req.getParameter("valuta");
		// Integer valutaId = Integer.valueOf(req.getParameter("valutaId"));
		
		redniBroj = redniBroj + 10;
		
		cenaPoKomadu =  (double) cena / (double) cenaZaKom;
		
		vrednostNoveStavke = kolicina * cenaPoKomadu;
		
		BigDecimal bd = new BigDecimal(vrednostNoveStavke).setScale(2, RoundingMode.HALF_UP);
		
		double konacnaVrednostStavke = bd.doubleValue();
		
		// Popuni objekt nova StavkaZZP
		novaStavka.setSifraZZP(zzp.getSifraZZP());
		novaStavka.setRedniBr(redniBroj);
		novaStavka.setStatus(1);
		novaStavka.setSifraPr(sifraPr);
		novaStavka.setOpisPr("test");
		novaStavka.setKolicina(kolicina);
		novaStavka.setCena(cena);
		novaStavka.setCenaZaKom(cenaZaKom);
		novaStavka.setVrednost(konacnaVrednostStavke);
		novaStavka.setValutaId(valuta);
		
		// Dodja u kolekciju stavki novog ZZP
		stavkeNovogZZP.add(novaStavka);
		
		model.addAttribute("novaStavka", novaStavka);
		
		return "zzp/nova-stavka";
		
	}
	
}
