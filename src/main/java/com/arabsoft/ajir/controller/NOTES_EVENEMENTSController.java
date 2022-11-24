package com.arabsoft.ajir.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arabsoft.ajir.dao.NOTES_EVENEMENTSDao;
import com.arabsoft.ajir.entities.Libre_demandeBis;
import com.arabsoft.ajir.entities.NOTES_EVENEMENTS;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/noteevent")
public class NOTES_EVENEMENTSController {
	@Autowired NOTES_EVENEMENTSDao noteevent;
	@GetMapping("/getall")
	public List <NOTES_EVENEMENTS> GETALL(){
		return noteevent.findAll();}
	
	
	@GetMapping("/getbyid/{id}")
	public Optional <NOTES_EVENEMENTS> GETbyid(@PathVariable("id")long id){
		return noteevent.findById(id);}
	@GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		  NOTES_EVENEMENTS fileDB = noteevent.get(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getFichier_joint() + "\"")
	        .body(fileDB.getFichier_joint());
	  }
	
	

		


}
