package com.boostati.integration;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boostati.entities.Provincia;
import com.boostati.services.ProvinciaService;

@RestController
@RequestMapping({"api", "rest"})
public class RegioniREST {

	@Autowired
	private ProvinciaService service;
	
	
	@GetMapping
	public List<Provincia> pippo(){
		return service.getAll();
	}
	
	@CrossOrigin
	@GetMapping("nomi-regioni")
	public List<String> getRegioni(){
		return this.service.getNomiProvincia();
	}
	
	@CrossOrigin
	@GetMapping("set-province")
	public List<String> getProvinceByReg(@RequestParam(name = "regione") String reg){
		List<Provincia> province = (reg==null || reg.isEmpty())?
				this.service.getAll():this.service.getAllFromReg(reg);
		
		return province.stream()
					.map(p->p.getComune())
					.collect(Collectors.toList());
	}
	
	@PostMapping
	public void addAlimento(@RequestBody Provincia a) {
		service.addProvincia(a);
	}
	
	@PutMapping
	public void updAlimento(@RequestBody Provincia a) {
		service.updProvincia(a);
	}
	
	@DeleteMapping("/{id}")
	public void delAlimento(@PathVariable int id) {
		service.delProvincia(id);
	}
	
}
