package com.boostati;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import com.boostati.dal.EtaDAO;
import com.boostati.dal.ProvinciaDAO;
import com.boostati.entities.Eta;
import com.boostati.entities.Provincia;
import com.boostati.services.ProvinciaService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class TestProv {
    @Autowired
    ProvinciaService prov;

    @Test
    @Transactional 
    void provService(){
        List<Provincia> c= prov.getAll();

        System.out.println("--------------------");
       //System.out.println(c);
       System.out.println("Quantità province totale: "+c.size());
        assertTrue(c.size()==107);
        System.out.println("--------------------");
    }
    
    @Test
    @Transactional 
    void provSicilia(){
     List <Provincia> a=prov.getAllFromReg("Sicilia");
     System.out.println("--------------------");
    // System.out.println(a);
     System.out.println("--------------------");
     System.out.println("Quantità province Sicilia: "+a.size());
     assertTrue(a.size()==9);
     System.out.println("--------------------");
    }

    @Test
    @Transactional 
    void provPiemonte(){
     List <Provincia> a=prov.getAllFromReg("Piemonte");
     System.out.println("--------------------");
    // System.out.println(a);
     System.out.println("--------------------");
     System.out.println("Quantità province Piemonte: "+a.size());
     assertTrue(a.size()==8);
     System.out.println("--------------------");
    }

    @Test
    @Transactional 
    void provVercelli(){
     Provincia a=prov.getProvinciaById(3);
     System.out.println("--------------------");
     System.out.println(a.getComune());
     assertTrue(a.getComune().equals("Vercelli") && a.getRegione().equals("Piemonte"));
     System.out.println("--------------------");

    }

    

}
