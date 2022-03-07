package com.boostati.presentation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boostati.services.EtaService;
import com.boostati.services.ProvinciaService;

@Controller
@RequestMapping()
public class PopolazioneCtrl {

	@Autowired
	EtaService etaSvc;
	
	@Autowired
	ProvinciaService regioneSvc;
	
	@CrossOrigin
	@GetMapping
	public String getHomePage(Model model) {
		return "index";
	}

	@GetMapping("/regione")
	public String getRegione(Model model) {
		return "regione";
	}
	
	@GetMapping("/{regione}/provincia")
	public String getProvinciaFromRegioneByPath(@PathVariable("regione") String regione, HttpSession session, Model model) {
		model.addAttribute("regione", regione);
		return "provincia";
	}
	
	@GetMapping("/comune/{comune_id}")
	public String getComune(@PathVariable("comune_id") int id, Model model) {
		var provincia = this.regioneSvc.getProvinciaById(id);
		model.addAttribute("comune", provincia);
		var totX100 = provincia.getTotale()*100;
		model.addAttribute("reg_per", Math.round((float)totX100/this.regioneSvc.getTotalePerRegione(provincia.getRegione())));
		model.addAttribute("tot_per", Math.round((float)totX100/this.regioneSvc.getPopolazioneTotale()));
		return "comune";
	}
	
	@GetMapping("/eta")
	public String getEta(Model model)
	{
		return "eta";
	}
	
}
