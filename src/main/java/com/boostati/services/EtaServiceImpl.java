package com.boostati.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boostati.dal.EtaDAO;
import com.boostati.dal.ProvinciaDAO;
import com.boostati.entities.Eta;

@Service
public class EtaServiceImpl implements EtaService {

	
	@Autowired
	private EtaDAO repo;
	@Override
	public void addEta(Eta e) {
		this.repo.save(e);

	}

	@Override
	public void updEta(Eta e) {
	this.repo.save(e);

	}

	@Override
	public void delEta(String eta) {
		this.repo.deleteByEta(eta);

	}

	@Override
	public List<Eta> getAllEta() {
		
		return this.repo.findAll();
	}

//	@Override
//	public List<Eta> getIntervalloEta(String inizio, String fine) {
//		
//		return this.repo.getEtaIntervallo(inizio, fine);
//	}

//	@Override
//	public List<Eta> getEtaByEta(int eta) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
