package com.boostati.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boostati.entities.Regione;
import com.boostati.services.RegioneService;

@RestController
@RequestMapping({"api", "rest"})
public class RegioniREST {

	@Autowired
	private RegioneService service;
	
	
	@GetMapping
	public List<Regione> pippo(){
		return service.getAll();
	}
	
	@CrossOrigin
	@GetMapping("nomi-regioni")
	public List<String> getCategorie(){
		return this.service.getNomiRegioni();
	}
	
	@PostMapping
	public void addAlimento(@RequestBody Regione a) {
		service.addRegione(a);
	}
	
	@PutMapping
	public void updAlimento(@RequestBody Regione a) {
		service.updRegione(a);
	}
	
	@DeleteMapping("/{id}")
	public void delAlimento(@PathVariable int id) {
		service.delRegione(id);
	}
	
}
