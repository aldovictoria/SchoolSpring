package com.Schoolv.Schoolv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Schoolv.Schoolv.model.Curso;
@Repository
public interface CursoRepo extends JpaRepository<Curso, Integer>{

}
