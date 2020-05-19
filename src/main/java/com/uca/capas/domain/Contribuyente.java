package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.el.parser.ParseException;

@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_contribuyente")
	private Integer codigoContribuyente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="c_importancia")
	private Importancia codigoImportancia;
	
	@Column(name = "s_nombre")
	@NotEmpty(message = "no puede ser vacio")
	@Size(max = 30, message = "no mas de 30 caracteres")
	private String nombre;
	
	@Column(name = "s_apellido")
	@NotEmpty(message = "no puede ser vacio")
	@Size(max = 30, message = "no mas de 30 caracteres")
	private String apellido;
	
	@Column(name = "s_nit")
	@NotEmpty(message = "no puede ser vacio")
	@Pattern(regexp="^$|[0-9]{14}", message="solo 14 digitos porfavor")
	private String s_nit;
	
	@Column(name = "f_fecha_ingreso")
	private Date fecha;
	
	public Contribuyente() {}

	public Integer getCodigoContribuyente() {
		return codigoContribuyente;
	}

	public void setCodigoContribuyente(Integer codigoContribuyente) {
		this.codigoContribuyente = codigoContribuyente;
	}


	public Importancia getCodigoImportancia() {
		return codigoImportancia;
	}

	public void setCodigoImportancia(Importancia codigoImportancia) {
		this.codigoImportancia = codigoImportancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getS_nit() {
		return s_nit;
	}

	public void setS_nit(String s_nit) {
		this.s_nit = s_nit;
	}

	public Date getFecha(){
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
