package com.arabsoft.ajir.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class Groupe_pretPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(insertable = false,updatable = false)
	private String  cod_soc  ;    	
	@Column(insertable = false,updatable = false)
	private String  cod_grp_pret;
	public String getCod_soc() {
		return cod_soc;
	}
	public void setCod_soc(String cod_soc) {
		this.cod_soc = cod_soc;
	}
	public String getCod_grp_pret() {
		return cod_grp_pret;
	}
	public void setCod_grp_pret(String cod_grp_pret) {
		this.cod_grp_pret = cod_grp_pret;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cod_grp_pret, cod_soc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groupe_pretPK other = (Groupe_pretPK) obj;
		return Objects.equals(cod_grp_pret, other.cod_grp_pret) && Objects.equals(cod_soc, other.cod_soc);
	} 
	
	
}
