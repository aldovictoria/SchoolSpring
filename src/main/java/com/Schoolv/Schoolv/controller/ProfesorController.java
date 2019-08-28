package com.Schoolv.Schoolv.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.Schoolv.Schoolv.repository.ProfesorRepo;
import com.Schoolv.Schoolv.model.Alumno;
import com.Schoolv.Schoolv.model.Profesor;

@RestController
@RequestMapping("/api")
public class ProfesorController {
	
	@Autowired
	private ProfesorRepo profesorRepo;
	
	@PostMapping("/setProfesor")
    public Profesor createProfesor(@Valid @RequestBody Profesor profesor) {
        return profesorRepo.save(profesor);
    }
	
	@DeleteMapping("/EliminarProfesor/{id}")
    public Map<String, Boolean> deleteAlumno(@PathVariable(value = "id") Integer profesorId)
         throws ResourceNotFoundException {
        Profesor profesor = profesorRepo.findById(profesorId)
       .orElseThrow(() -> new ResourceNotFoundException("profesor not found for this id :: " + profesorId));

        profesorRepo.delete(profesor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	}
	
	
	@PutMapping("/updateProfesor/{id}")
    public ResponseEntity<Profesor> updateProfesor(@PathVariable(value = "id") Integer profesorId,
         @Valid @RequestBody Profesor profesorDetails) throws ResourceNotFoundException {
		Profesor profesor = profesorRepo.findById(profesorId)
        .orElseThrow(() -> new ResourceNotFoundException("profesor not found for this id :: " + profesorId));

        
       profesor.setNombre(profesorDetails.getNombre());
        
        final Profesor updatedProfesor = profesorRepo.save(profesor);
        return ResponseEntity.ok(updatedProfesor);
	}
	
	
	@GetMapping("/Profesor/{id}")
    public ResponseEntity<Profesor> getProfesorById(@PathVariable(value = "id") Integer profesorId)
        throws ResourceNotFoundException {
		Profesor profesor =  profesorRepo.findById(profesorId)
          .orElseThrow(() -> new ResourceNotFoundException("profesor not found for this id :: " + profesorId));
        return ResponseEntity.ok().body(profesor);
    }
	

}
