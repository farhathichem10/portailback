package com.arabsoft.ajir.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arabsoft.ajir.entities.TypeBulletin;

public interface TypeBulletinDao extends JpaRepository<TypeBulletin, String>{

	@Query("select c from TypeBulletin c ")
	public List<TypeBulletin> getTypeBul();
}
