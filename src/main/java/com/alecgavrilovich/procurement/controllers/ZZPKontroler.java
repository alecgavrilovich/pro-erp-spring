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
import com.alecgavrilovich.procurement.domain.Dobavljac;
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
	private List<StavkaZZP> stavkeZZP = new ArrayList<>();
	private int redniBroj = 0;
	
	
	@RequestMapping("")
	public String pronadjiSveZZP(Model model) {
		
		// Ocisti objekt ZZP
		zzp = new ZZP();
		stavkeZZP.clear();
		// zzp.setStavke(stavkeZZP);
		
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
		List<Dobavljac> listaDobavljaca = zzpDBB.vratiDobavljace();
		
		zzp.setSifraZZP(sifraNovogZZP);
		zzp.setDatum(datum);
		zzp.setVrednostZZP(0);
		
		model.addAttribute("zzp", zzp);
		model.addAttribute("sifraNovogZZP", sifraNovogZZP);
		model.addAttribute("datumZZP", datum);
		model.addAttribute("listaProizvoda", listaProizvoda);
		model.addAttribute("listaValuta", listaValuta);
		model.addAttribute("listaDobavljaca", listaDobavljaca);
		
		return "zzp/novi-zzp";
		
	}
	
	@RequestMapping(value="/sacuvajZZP", method = RequestMethod.POST)
	public String sacuvajZZP(@RequestParam("sifraDob") Integer sifraDob, @RequestParam("valutaZZP") String valuta, @RequestParam("vrednostZZP") double vrednostZZP) {
		
		zzp.setSifraDob(sifraDob);
		zzp.setImeDob("test");
		zzp.setVrednostZZP(vrednostZZP);
		zzp.setValuta(valuta);
		zzp.setStavke(stavkeZZP);
		
		zzpDBB.sacuvajZZP(zzp);
		
		return "redirect:/zzp";
		
	}
	
	@RequestMapping(value="/dodajStavku", method = RequestMethod.POST)
	public String dodajStavku(HttpServletRequest req, Model model) {
		
		StavkaZZP st = new StavkaZZP();
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
		st.setSifraZZP(zzp.getSifraZZP());
		st.setRedniBr(redniBroj);
		st.setStatus(1);
		st.setSifraPr(sifraPr);
		st.setOpisPr("test");
		st.setKolicina(kolicina);
		st.setCena(cena);
		st.setCenaZaKom(cenaZaKom);
		st.setVrednost(konacnaVrednostStavke);
		st.setValutaId(valuta);
		
		// Dodja u kolekciju stavki novog ZZP
		stavkeZZP.add(st);
		
		model.addAttribute("st", st);
		
		return "zzp/nova-stavka";
		
	}
	
	
	// Izmena
	
	@RequestMapping(value="/izmeniZZP/{sifraZZP}")
	public String izmeniZZP(@PathVariable("sifraZZP") Integer sifraZZP, Model model) {
		
		ZZP zzpZaIzmenu = zzpDBB.pronadjiZZP(sifraZZP);
		
		zzp.setSifraZZP(zzpZaIzmenu.getSifraZZP());
		zzp.setDatum(zzpZaIzmenu.getDatum());
		zzp.setSifraDob(zzpZaIzmenu.getSifraDob());
		zzp.setImeDob(zzpZaIzmenu.getImeDob());
		zzp.setValuta(zzpZaIzmenu.getValuta());
		zzp.setVrednostZZP(zzpZaIzmenu.getVrednostZZP());
		
		zzpZaIzmenu.getStavke().forEach(stavkeZZP::add);
		
		List<Proizvod> listaProizvoda = prDBB.pronadjiProizvode();
		List<Valuta> listaValuta = zzpDBB.vratiValute();
		List<Dobavljac> listaDobavljaca = zzpDBB.vratiDobavljace();
		
		// List<StavkaZZP> stavke = zzpZaIzmenu.getStavke();
		
		model.addAttribute("zzp", zzpZaIzmenu);
		model.addAttribute("stavke", zzpZaIzmenu.getStavke());
		model.addAttribute("listaProizvoda", listaProizvoda);
		model.addAttribute("listaValuta", listaValuta);
		model.addAttribute("listaDobavljaca", listaDobavljaca);
		
		return "zzp/izmeni-zzp";
		
	}
	
	
	@RequestMapping(value="/izmeniStavku", method = RequestMethod.POST)
	public String izmeniStavku(HttpServletRequest req, Model model) {
		
		StavkaZZP stavkaZaIzmenu = new StavkaZZP();
		double vrednostStavke;
		double cenaPoKomadu;
		
		int sifraPr = Integer.valueOf(req.getParameter("sifraPr"));
		int kolicina = Integer.valueOf(req.getParameter("kolicina"));
		int cena = Integer.valueOf(req.getParameter("cena"));
		int cenaZaKom = Integer.valueOf(req.getParameter("cenaZaKom"));
		String valuta = req.getParameter("valuta");
		int redniBr = Integer.valueOf(req.getParameter("redniBr"));
		
		
		cenaPoKomadu =  (double) cena / (double) cenaZaKom;
		
		vrednostStavke = kolicina * cenaPoKomadu;
		
		BigDecimal bd = new BigDecimal(vrednostStavke).setScale(2, RoundingMode.HALF_UP);
		
		double konacnaVrednostStavke = bd.doubleValue();
		
		stavkeZZP.forEach((st) -> {
			
			if (st.getRedniBr() == redniBr) {
				st.setStatus(2);
				st.setSifraPr(sifraPr);
				st.setOpisPr("test");
				st.setKolicina(kolicina);
				st.setCena(cena);
				st.setCenaZaKom(cenaZaKom);
				st.setVrednost(konacnaVrednostStavke);
				st.setValutaId(valuta);
			}
			
		});
		
		
		// Popuni objekt StavkaZZP
		stavkaZaIzmenu.setSifraZZP(zzp.getSifraZZP());
		stavkaZaIzmenu.setRedniBr(redniBr);
		stavkaZaIzmenu.setStatus(2);
		stavkaZaIzmenu.setSifraPr(sifraPr);
		stavkaZaIzmenu.setOpisPr("test");
		stavkaZaIzmenu.setKolicina(kolicina);
		stavkaZaIzmenu.setCena(cena);
		stavkaZaIzmenu.setCenaZaKom(cenaZaKom);
		stavkaZaIzmenu.setVrednost(konacnaVrednostStavke);
		stavkaZaIzmenu.setValutaId(valuta);
		
		// Dodja u kolekciju stavki novog ZZP
		
		model.addAttribute("stavkaZaIzmenu", stavkaZaIzmenu);
		
		return "zzp/izmeni-stavku";
	}
	
	
	
}
