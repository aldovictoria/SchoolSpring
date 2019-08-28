package com.Schoolv.Schoolv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Schoolv.Schoolv.model.Calificacion;

@Repository
public interface CalificacionRepo extends JpaRepository<Calificacion, Integer> {

}
