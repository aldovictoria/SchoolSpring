package com.Schoolv.Schoolv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Schoolv.Schoolv.model.Expediente;

@Repository
public interface ExpedienteRepo extends JpaRepository<Expediente, Integer> {

}
