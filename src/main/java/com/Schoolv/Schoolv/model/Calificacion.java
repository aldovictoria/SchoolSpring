package com.Schoolv.Schoolv.model;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "Calificacion")
public class Calificacion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCalificacion;
	private Integer calificacion;
	private Integer idAlumno;
	private Integer idMateria;
	
	public Calificacion(){}
	
	
	public Calificacion(Integer idCalificacion, Integer calificacion, Integer idAlumno, Integer idMateria) {
		super();
		this.idCalificacion = idCalificacion;
		this.calificacion = calificacion;
		this.idAlumno = idAlumno;
		this.idMateria = idMateria;
	}
	
	
	
	public Integer getIdCalificacion() {
		return idCalificacion;
	}
	public void setIdCalificacion(Integer idCalificacion) {
		this.idCalificacion = idCalificacion;
	}
	
	
	@Column(name = "calificacion", nullable = false)
	public Integer getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
	
	@Column(name = "idAlumno", nullable = false)
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	@Column(name = "idMateria", nullable = false)
	public Integer getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}


}
