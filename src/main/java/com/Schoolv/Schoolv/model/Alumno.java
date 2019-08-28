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
@Table(name = "Alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Matricula;
	private String Nombre;
	private Integer edad;
	private String direccion;
	private String telefono;
	
	@ManyToMany()
    @JoinTable(name="Alumno_curso", joinColumns= @JoinColumn(name="idAlumno"),inverseJoinColumns=@JoinColumn(name="idCurso"))
	private Set<Curso> cursos = new HashSet<Curso>();
	
	
	public Alumno() {}
	public Alumno(Integer matricula, String nombre, Integer edad, String direccion, String telefono,Set<Curso> cursos) {
		super();
		Matricula = matricula;
		Nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cursos = cursos;
	}

    public Integer getMatricula() {
        return Matricula;
    }
    public void setMatricula(Integer Matricula) {
        this.Matricula = Matricula;
        
    }
    
    @Column(name = "Nombre", nullable = false)
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    @Column(name = "Edad", nullable = false)
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Column(name = "Direccion", nullable = false)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Column(name = "Telefono", nullable = false)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Set<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
    
        
	
	
}
