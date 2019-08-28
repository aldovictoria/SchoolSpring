package com.Schoolv.Schoolv.model;

import javax.persistence.JoinColumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Expediente")
public class Expediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idExpediente;
	private Integer idAlumno;
	private String Carrera ;
	private String tipoSangre;
	
	public Expediente(){}
	public Expediente(Integer idExpediente, Integer idAlumno, String carrera, String tipoSangre) {
		super();
		this.idExpediente = idExpediente;
		this.idAlumno = idAlumno;
		Carrera = carrera;
		this.tipoSangre = tipoSangre;
	}
	
	public Integer getIdExpediente() {
		return idExpediente;
	}
	public void setIdExpediente(Integer idExpediente) {
		this.idExpediente = idExpediente;
	}
	
	@Column(name = "idAlumno", nullable = false)
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	@Column(name = "Carrera", nullable = false)
	public String getCarrera() {
		return Carrera;
	}
	public void setCarrera(String carrera) {
		Carrera = carrera;
	}
	
	@Column(name = "tipoSangre", nullable = false)
	public String getTipoSangre() {
		return tipoSangre;
	}
	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	
	
	
}
