package com.boostati.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boostati.dal.RegioneDAO;
import com.boostati.entities.Regione;


@Service
public class RegioneServiceImpl implements RegioneService {

	@Autowired
	private RegioneDAO repo;
	
	@Override
	public void addRegione(Regione a) {
		this.repo.save(a);

	}

	@Override
	public void updRegione(Regione a) {
		this.repo.save(a);

	}

	@Override
	public void delRegione(int id) {
		this.repo.deleteById(id);

	}

	@Override
	public List<Regione> getRegioni() {
		return this.repo.findAll();
	}

	@Override
	public Regione getRegioneById(int id) {
		return this.repo.getById(id);
	}
}
