package com.boostati.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boostati.entities.Regione;

@Repository
public interface RegioneDAO extends JpaRepository<Regione, Integer> {

	List<Regione> findByCategoria(String categoria);
	//List<String> findDistinctByCategoria();
	
}
