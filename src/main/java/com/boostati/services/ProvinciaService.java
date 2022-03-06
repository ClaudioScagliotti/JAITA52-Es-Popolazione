package com.boostati.services;

import java.util.List;

import com.boostati.entities.Regione;

public interface RegioneService {
	
	//CRUD
	void addRegione(Regione a);
	void updRegione(Regione a);
	void delRegione(int id);
	
	List<Regione> getAll();
	
	List<String> getNomiRegioni();

	
	Regione getRegioneById(int id);
	
}
