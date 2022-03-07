package com.boostati.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boostati.entities.Eta;
import com.boostati.services.EtaService;

@RestController
@RequestMapping({"api", "rest"})
public class EtaRest {

	@Autowired
	private EtaService service;
	
	@CrossOrigin
	@GetMapping("/eta-data")
	public List<Eta> getDataBetween(
			@RequestParam(name = "min") int min,
			@RequestParam(name = "max") int max){
		return service.getEtaBetween(min,max);
	}
	
	@CrossOrigin
	@GetMapping("/allData")
	public List<Eta> getAllData(){
		return service.getAllEta();
	}
}
