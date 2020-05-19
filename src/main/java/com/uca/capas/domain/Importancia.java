package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "importancia")
public class Importancia {

	@Id
	@Column(name = "c_importancia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoImportancia;
	
	@Column(name = "s_importancia")
	private String nombreImportancia;
	
	public Importancia () {}

	public Integer getCodigoImportancia() {
		return codigoImportancia;
	}

	public void setCodigoImportancia(Integer codigoImportancia) {
		this.codigoImportancia = codigoImportancia;
	}

	public String getNombreImportancia() {
		return nombreImportancia;
	}

	public void setNombreImportancia(String nombreImportancia) {
		this.nombreImportancia = nombreImportancia;
	}
	
	
}
