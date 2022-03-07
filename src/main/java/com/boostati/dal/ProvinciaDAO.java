package com.boostati.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boostati.entities.Provincia;

@Repository
public interface ProvinciaDAO extends JpaRepository<Provincia, Integer> {

	@Query(value = "select sum(totale) from popolazione_italiana_regione", nativeQuery = true)
	long totPopulation();
	
	@Query(value = "select sum(totale) from popolazione_italiana_regione where regione=?1", nativeQuery = true)
	long regTotPopulation(String regione);
	
	List<Provincia> findByRegione(String regione);
}
