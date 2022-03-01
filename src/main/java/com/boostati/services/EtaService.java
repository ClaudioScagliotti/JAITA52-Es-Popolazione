package com.boostati.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boostati.entities.Eta;

@Service
public interface EtaService {
	void addEta (Eta e);
	void updEta(Eta e);
	void delEta(int id);
	
	List <Eta> getAllEta();
	List <Eta> getIntervalloEta(int inizio, int fine);
	List <Eta> getEtaByEta(int eta);
	
	

}
