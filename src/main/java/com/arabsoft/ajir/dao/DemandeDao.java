package com.arabsoft.ajir.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.arabsoft.ajir.entities.Libre_demande;

public interface DemandeDao extends JpaRepository<Libre_demande, Long> {
	
	@Query(value = "select \r\n"
			+ "       ID_LIBRE_DEMANDE\r\n"
			+ "       COD_SOC,  \r\n"
			+ "       MAT_PERS,\r\n"
			+ "       TYP_DEMANDE,\r\n"
			+ "       DATE_DEMANDE,\r\n"
			+ "       DAT_DEBUT,\r\n"
			+ "       DAT_FIN,\r\n"
			+ "       HEUR_S,\r\n"
			+ "       MIN_S,\r\n"
			+ "       HEUR_R,\r\n"
			+ "       MIN_R,\r\n"
			+ "       COD_TIT,\r\n"
			+ "       COD_TYP,\r\n"
			+ "       COD_THEME,\r\n"
			+ "       COD_GRP_PRET,\r\n"
			+ "       TYP_PRET,\r\n"
			+ "       MNT_DEM,\r\n"
			+ "       NUM_ATTEST,\r\n"
			+ "       TXT_DEM,\r\n"
			+ "       TXT_REPONSE,\r\n"
			+ "       REPONSE_CHEF,\r\n"
			+ "       REPONSE,\r\n"
			+ "       TXT_CHEF,\r\n"
			+ "       FILE_NAME,\r\n"
			+ "       CONTENT_TYPE,\r\n"
			+ "       PATH,\r\n"
			+ "       FICHIER_JOINT ,\r\n"
			+ "       COD_M,\r\n"
			+ "       CNG_TEMPS_FIN,\r\n"
			+ "       CNG_TEMPS_DEBUT,\r\n"
			+ "       CNG_TEMPS,\r\n"
			+ "       COD_AUT,\r\n"
			+ "       ANNEE\r\n"
			+ "from libre_demande\r\n"
			+ "where COD_SOC=:codSoc\r\n" , nativeQuery = true)
	public List<Libre_demande> getListDemande(@Param("codSoc") String codSoc);
	
	
	
	@Query(value="select ID_LIBRE_DEMANDE,COD_SOC,MAT_PERS,TYP_DEMANDE,DATE_DEMANDE,"
			+ "DAT_DEBUT,DAT_FIN,HEUR_S,MIN_S,HEUR_R,MIN_R,COD_TIT,COD_TYP,COD_THEME,COD_GRP_PRET,TYP_PRET,MNT_DEM"
			+ ",NUM_ATTEST,TXT_DEM,TXT_REPONSE,REPONSE_CHEF, REPONSE, TXT_CHEF,FILE_NAME,CONTENT_TYPE"
			+ ",PATH,FICHIER_JOINT,COD_M,CNG_TEMPS_FIN,CNG_TEMPS_DEBUT,CNG_TEMPS,COD_AUT"
			+ ",ANNEE from libre_demande where COD_SOC=:codSoc and MAT_PERS=:matpers and TYP_DEMANDE=:type",nativeQuery = true)
	public List<Libre_demande> get(@Param("codSoc")String codSoc,@Param("matpers") String matpers,@Param("type") String type);

	
	@Query(value="select id_libre_demande,\r\n"
			+ "       l.cod_soc,\r\n"
			+ "       l.mat_pers,\r\n"
			+ "       (p.nom_pers || ' ' || p.pren_pers) npren_pers,\r\n"
			+ "       typ_demande,\r\n"
			+ "       decode(typ_demande,\r\n"
			+ "              'C',\r\n"
			+ "              'Congés',\r\n"
			+ "              'F',\r\n"
			+ "              'Formation',\r\n"
			+ "              'P',\r\n"
			+ "              'Prets et avances',\r\n"
			+ "              'A',\r\n"
			+ "              'Autorisations',\r\n"
			+ "              'S',\r\n"
			+ "              'Situation Administrtive',\r\n"
			+ "              'D',\r\n"
			+ "              'Attestations') lib_demande,\r\n"
			+ "       date_demande,\r\n"
			+ "       dat_debut,\r\n"
			+ "       dat_fin,\r\n"
			+ "       heur_s,\r\n"
			+ "       min_s,\r\n"
			+ "       heur_r,\r\n"
			+ "       min_r,\r\n"
			+ "       cod_tit,\r\n"
			+ "       pk_get_lib.GET_TITRE_FORM$LIB_TIT(WCOD_TIT => l.cod_tit) titre,\r\n"
			+ "       cod_typ,\r\n"
			+ "       pk_get_lib.GET_TYPE_FORMA$LIB_TYP(WCOD_TIT => l.cod_tit,\r\n"
			+ "                                         WCOD_TYP => l.cod_typ) type_formation,\r\n"
			+ "       cod_theme,\r\n"
			+ "       pk_get_lib.GET_THEME$LIB_THEME(WCOD_TIT   => l.cod_tit,\r\n"
			+ "                                      WCOD_TYP   => l.cod_typ,\r\n"
			+ "                                      WCOD_THEME => l.cod_theme) theme,\r\n"
			+ "       cod_grp_pret,\r\n"
			+ "       pk_get_lib.GET_GROUPE_PRE$LIB_GRP_PRET(WCOD_SOC      => l.cod_soc,\r\n"
			+ "                                              WCOD_GRP_PRET => l.cod_grp_pret) group_pret,\r\n"
			+ "       typ_pret,\r\n"
			+ "       pk_get_lib.GET_TYPE_PRET$LIB_PRET(WCOD_SOC      => l.cod_soc,\r\n"
			+ "                                         WCOD_GRP_PRET => l.cod_grp_pret,\r\n"
			+ "                                         WTYP_PRET     => l.typ_pret) lib_pret,\r\n"
			+ "       mnt_dem,\r\n"
			+ "       num_attest,\r\n"
			+ "       txt_dem,\r\n"
			+ "       txt_reponse,\r\n"
			+ "       reponse_chef,\r\n"
			+ "       reponse,\r\n"
			+ "       txt_chef,\r\n"
			+ "       file_name,\r\n"
			+ "       content_type,\r\n"
			+ "       path,\r\n"
			+ "       fichier_joint,\r\n"
			+ "       cod_m,\r\n"
			+ "       pk_get_lib.GET_MOTIF_J$LIB_MOT(WCOD_M => l.cod_m) motif,\r\n"
			+ "       cng_temps_fin,\r\n"
			+ "       cng_temps_debut,\r\n"
			+ "       cng_temps,\r\n"
			+ "       cod_aut,\r\n"
			+ "       pk_get_lib.GET_TYP_AUTORI$LIB_TYP_AUT(l.cod_aut) lib_autorisation,\r\n"
			+ "       annee\r\n"
			+ "  from libre_demande l, personnel p\r\n"
			+ " where l.cod_soc = p.cod_soc \r\n"
			+ "	  and l.mat_pers = p.mat_pers \r\n"
			+ "   and l.cod_soc =:codSoc\r\n"
			+ "   and l.mat_pers =:matpers\r\n" 
			+ "and TYP_DEMANDE=:type",nativeQuery = true)
	public List<Libre_demande> getDem(@Param("codSoc")String codSoc,@Param("matpers") String matpers,@Param("type") String type);


	@Query("select a from Libre_demande a where a.idlibredemande=:x ")
	 public Libre_demande gettByid(@Param("x") Long mat);
	
	
	public Libre_demande findByIdlibredemande(Long id);

	
}





