package com.Schoolv.Schoolv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Schoolv.Schoolv.model.Alumno;
@Repository
public interface AlumnoRepo extends JpaRepository<Alumno, Integer> {
	
	
	
}
