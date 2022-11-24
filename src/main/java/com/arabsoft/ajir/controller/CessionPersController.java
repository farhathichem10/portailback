package com.arabsoft.ajir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arabsoft.ajir.dao.CessionPersRep;
import com.arabsoft.ajir.dao.LigCessionRep;
import com.arabsoft.ajir.dao.PersonnelRep;
import com.arabsoft.ajir.dao.PretPersDetRep;
import com.arabsoft.ajir.dao.RembourserCessionRep;
import com.arabsoft.ajir.entities.CessionPers;
import com.arabsoft.ajir.entities.PretPersDet;





@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cessionpers")
public class CessionPersController {
	
	@Autowired
	CessionPersRep cessionPersRep;

	@Autowired
	PersonnelRep personnelRep;
	
	@Autowired
	LigCessionRep ligCessionRep;
	@Autowired
	RembourserCessionRep   rembourserCessionRep;
	
	@Autowired
	PretPersDetRep pretPersDetRep;

	



	@PostMapping("/cessionPersLig")
	public CessionPers getCessionPers(@RequestBody CessionPers b){
		
		String codSoc = b.getCod_soc();
		String matPers = b.getMat_pers();
		List<CessionPers>bs=(List<CessionPers>) this.cessionPersRep.getCessionLigCessionPers(codSoc, matPers);
		
		
	
	    for (int i = 0; i <bs.size(); i++) {
	        System.out.println(bs.get(i));
	        if(i==bs.size()-1) {
	        bs.get(i).setLigCession(ligCessionRep.getLigCession(codSoc, matPers));
	        bs.get(i).setPersonnel(personnelRep.getPers(codSoc, matPers));
	        }
	      }
		
		return bs.get(bs.size()-1) ;
		
	}
	
	//to show the det with pret
	@PostMapping("/cessionPersLigPret")
	public CessionPers getCessionPersPret(@RequestBody CessionPers b){
		
		
		
		String codSoc = b.getCod_soc();
		String matPers = b.getMat_pers();
		Integer codPret=b.getCod_pret();
		List<CessionPers>bs=(List<CessionPers>) this.cessionPersRep.getCessionLigCessionPersPret(codSoc, matPers, codPret);
		
		
	
	    for (int i = 0; i <bs.size(); i++) {
	        System.out.println(bs.get(i));
	        if(i==bs.size()-1) {
	        bs.get(i).setLigCession(ligCessionRep.getLigCessionPret(codSoc, matPers, codPret));
	        bs.get(i).setRembourserCession(rembourserCessionRep.getRembourserCession(codSoc, matPers, codPret));
	        bs.get(i).setPersonnel(personnelRep.getPers(codSoc, matPers));
	        }
	      }
		
		return bs.get(bs.size()-1) ;
		
	}
	//Get pret from tab personnel and pret_pers
	
	@PostMapping("/getpret")
	public PretPersDet getPret(@RequestBody PretPersDet b){
		
		
		
		String codSoc = b.getCod_soc();
		String matPers = b.getMat_pers();
		Integer codPret = b.getCod_pret();
		
		PretPersDet pr= this.pretPersDetRep.getPret(codSoc, matPers,codPret);
		pr.setListCodPret(this.pretPersDetRep.getListCodPret(codSoc, matPers));
		
		return pr;
		
	}
	@CrossOrigin
	@GetMapping("/getlistpret/{codSoc}/{matPers}")
	 public List<Integer> getListCodPret(@PathVariable String codSoc,@PathVariable String matPers){
		
		
		
		return pretPersDetRep.getListCodPret2(codSoc, matPers);
		
		
	}
	
}
