package com.Schoolv.Schoolv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Schoolv.Schoolv.model.Profesor;

@Repository
public interface ProfesorRepo extends JpaRepository<Profesor, Integer> {

}
