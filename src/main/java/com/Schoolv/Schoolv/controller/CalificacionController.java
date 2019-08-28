package com.Schoolv.Schoolv.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Schoolv.Schoolv.exception.ResourceNotFoundException;
import com.Schoolv.Schoolv.model.Calificacion;
import com.Schoolv.Schoolv.repository.CalificacionRepo;


@RestController
@RequestMapping("/api")
public class CalificacionController {
	
	 @Autowired
	 private CalificacionRepo calificacionRepo;
	 
	 
	 @PostMapping("/setCalificacion")
	 public Calificacion createCalificacion(@Valid @RequestBody Calificacion calificacion) {
	       return calificacionRepo.save(calificacion);
	 }
	

}
