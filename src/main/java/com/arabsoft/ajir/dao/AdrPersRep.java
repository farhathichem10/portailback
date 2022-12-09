package com.arabsoft.ajir.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arabsoft.ajir.entities.AdrPers;
import com.arabsoft.ajir.entities.CleAdrPers;

 

@Repository
public interface AdrPersRep extends JpaRepository<AdrPers, CleAdrPers>{
	
	  Boolean existsByAdrelectronique(String email);
	  Optional <AdrPers> findByAdrelectronique(String email);
	  @Query("select a from AdrPers a where a.adr_courant='O' and a.adrelectronique=:adrelectronique")
	   AdrPers findByAdrelectroniqueo(@Param("adrelectronique") String adrelectronique);
	  @Query("select a from AdrPers a where a.adr_courant='O' and a.adrelectronique=:adrelectronique")
	  Optional<AdrPers> findByAdrelectroniqueoo(@Param("adrelectronique") String adrelectronique);


		@Query(value="select cod_soc,\r\n"
				+ "	   mat_pers,\r\n"
				+ "(pk_get_lib.GET_GOUVERNORA$LIB_GOUV(cod_gouv)) lib_gouv,\r\n"
				+ "	   num_adr,\r\n"
				+ "	   cod_gouv,\r\n"
				+ "	   (pk_get_lib.GET_GOUVERNORA$LIB_GOUV(cod_gouv)) lib_gouv,\r\n"
				+ "	   cod_deleg,\r\n"
				+ "	   cod_post,\r\n"
				+ "	   rue,\r\n"
				+ "	   rue_a,\r\n"
				+ "	   tel_pers,\r\n"
				+ "	   fax_pers,\r\n"
				+ "	   adr_courant,\r\n"
				+ "	   adr_electronique,\r\n"
				+ "	   tel_port_pers,\r\n"
				+ "	   numero_adr,\r\n"
				+ "	   etat_adr,\r\n"
				+ "	   immb_pers,\r\n"
				+ "	   app_pers,\r\n"
				+ "	   local_pers,\r\n"
				+ "	   id_adr_pers,\r\n"
				+ "	   rec_mail,\r\n"
				+ "	   cod_user,\r\n"
				+ "  (pk_get_lib.GET_GOUVERNORA$LIB_GOUV(cod_gouv)) libnompre \r\n"

				+ "from adr_pers \r\n"
				+ "where cod_soc = :codSoc and mat_pers = :matPers",nativeQuery = true)
		public List<AdrPers> getAdrPers(@Param("codSoc") String codSoc,@Param("matPers") String matPers);
		@Query(value="select a.cod_soc,\r\n"
				+ "	   a.mat_pers,\r\n"
				+ "(pk_get_lib.GET_GOUVERNORA$LIB_GOUV(a.cod_gouv)) lib_gouv,\r\n"
				+ "	   a.num_adr,\r\n"
				+ "	   a.cod_gouv,\r\n"
				+ "	   (pk_get_lib.GET_GOUVERNORA$LIB_GOUV(a.cod_gouv)) lib_gouv,\r\n"
				+ "	   a.cod_deleg,\r\n"
				+ "	   a.cod_post,\r\n"
				+ "	   a.rue,\r\n"
				+ "	   a.rue_a,\r\n"
				+ "	   a.tel_pers,\r\n"
				+ "	   a.fax_pers,\r\n"
				+ "	   a.adr_courant,\r\n"
				+ "	   a.adr_electronique,\r\n"
				+ "	   a.tel_port_pers,\r\n"
				+ "	   a.numero_adr,\r\n"
				+ "	   a.etat_adr,\r\n"
				+ "	   a.immb_pers,\r\n"
				+ "	   a.app_pers,\r\n"
				+ "	   a.local_pers,\r\n"
				+ "	   a.id_adr_pers,\r\n"
				+ "	   a.rec_mail,\r\n"
				+ "	   a.cod_user,\r\n"
				+ "(select nom_pers||' '||pren_pers from personnel s where s.cod_soc  = a.cod_soc and s.mat_pers  = a.mat_pers)  libnompre \r\n"
				+ "from adr_pers a,personnel p \r\n"
				+ "where a.cod_soc=p.cod_soc and a.mat_pers=p.mat_pers and (get_pere_by_pere(a.cod_soc,p.cod_serv,:cod)=:cod or a.mat_pers=:matpers)\r\n"
				+ "and :matpers in(select mat_pers from service where cod_serv=:cod) and p.etat_act in (0,1) \r\n ",nativeQuery = true)
		public List<AdrPers> getAdrPers22(@Param("cod") String cod, @Param("matpers") String mat);


}
