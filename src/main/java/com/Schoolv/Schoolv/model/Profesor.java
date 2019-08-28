package com.Schoolv.Schoolv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//import com.Schoolv.Schoolv.model.Curso;

@Entity
@Table(name = "Profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Matricula;
	private String Nombre;
	
	@ManyToMany()
    @JoinTable(name="profesor_curso", joinColumns= @JoinColumn(name="idProfesor"),inverseJoinColumns=@JoinColumn(name="idCurso"))
	private Set<Curso> cursos = new HashSet<Curso>();
	public Profesor() {}
	public Profesor(Integer matricula, String nombre, Set<Curso> cursos) {
		super();
		Matricula = matricula;
		Nombre = nombre;
		this.cursos = cursos;
	}
	
	
	public Integer getMatricula() {
		return Matricula;
	}
	public void setMatricula(Integer matricula) {
		Matricula = matricula;
	}
	
	@Column(name = "Nombre", nullable = false)
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Set<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
		
}
