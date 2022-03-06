package com.boostati.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boostati.dal.ProvinciaDAO;
import com.boostati.entities.Provincia;


@Service
public class ProvinciaServiceImpl implements ProvinciaService {

	@Autowired
	private ProvinciaDAO repo;
	
	@Override
	public void addProvincia(Provincia a) {
		this.repo.save(a);

	}

	@Override
	public void updProvincia(Provincia a) {
		this.repo.save(a);

	}

	@Override
	public void delProvincia(int id) {
		this.repo.deleteById(id);

	}

	@Override
	public List<Provincia> getAll() {
		return this.repo.findAll();
	}

	
	@Override
	public List<String> getNomiProvincia() {
		return this.getAll().stream()
				.map(r->r.getRegione())
				.distinct()
				.collect(Collectors.toList());
	}
	
	@Override
	public Provincia getProvinciaById(int id) {
		return this.repo.getById(id);
	}
	
	@Override
	public List<Provincia> getAllFromReg(String region) {
		return this.repo.findByRegione(region);
	}
}
