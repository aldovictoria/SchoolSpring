package com.Schoolv.Schoolv.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Curso")
public class Curso {
	
	public Curso(Integer id, String nombreCurso) {
		
		Id = id;
		NombreCurso = nombreCurso;
	}
	
	public Curso() {
		
	}
	
	private Integer Id;
	private String NombreCurso;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	@Column(name = "NombreCurso", nullable = false)
	public String getNombreCurso() {
		return NombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		NombreCurso = nombreCurso;
	}
	
	
	
}
