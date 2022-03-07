package com.boostati.services;

import java.util.List;

import com.boostati.entities.Provincia;

public interface ProvinciaService {
	
	//CRUD
	void addProvincia(Provincia a);
	void updProvincia(Provincia a);
	void delProvincia(int id);
	
	List<Provincia> getAll();
	
	List<Provincia> getAllFromReg(String region);
	
	List<String> getNomiProvincia();

	Provincia getProvinciaById(int id);
	
	long getTotalePerRegione(String reg);
	
	long getPopolazioneTotale();
	
}
