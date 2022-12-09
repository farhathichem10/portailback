package com.arabsoft.ajir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arabsoft.ajir.dao.AdrPersRep;
import com.arabsoft.ajir.entities.AdrPers;
import com.arabsoft.ajir.entities.Personnel;

@RestController
@CrossOrigin("*")
@RequestMapping("/Adrpers")
public class Adrperscont {
	@Autowired AdrPersRep adr  ;
	@GetMapping("/getAdrpers/{cod_serv}/{mat_pers}")
	public List<AdrPers> getInfosPers2(@PathVariable("cod_serv")String cod_serv,@PathVariable ("mat_pers")String mat_pers) {
		
		
		return this.adr.getAdrPers22(cod_serv,mat_pers);

}}
