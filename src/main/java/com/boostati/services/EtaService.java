package com.boostati.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boostati.entities.Eta;

public interface EtaService {
	void addEta (Eta e);
	void updEta(Eta e);
	void delEta(String id);
	
	
	List <Eta> getAllEta();
	
	List<Eta> getEtaBetween(int min, int max);
}
