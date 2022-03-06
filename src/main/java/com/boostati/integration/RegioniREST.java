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
	public List<Provincia> getProvinceByReg(@RequestParam(name = "regione") String reg){
		return reg==null || reg.isEmpty()?
					this.service.getAll():
					this.service.getAllFromReg(reg);
	}
	
	@CrossOrigin
	@GetMapping("{provincia_id}")
	public Provincia getProvincia(@PathVariable(name = "provincia_id") int provincia_id){
		return this.service.getProvinciaById(provincia_id);
	}
}
