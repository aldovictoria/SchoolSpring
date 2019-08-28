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
import com.Schoolv.Schoolv.model.Alumno;
import com.Schoolv.Schoolv.model.Curso;
import com.Schoolv.Schoolv.repository.AlumnoRepo;

@RestController
@RequestMapping("/api")
public class AlumnoController {
	
	@Autowired
	private AlumnoRepo alumnoRepo;
	
	@GetMapping("/Alumnos")
    public List<Alumno> getAllAlumnos() {
        return alumnoRepo.findAll();
    }
	
	
	@PostMapping("/setAlumno")
    public Alumno createAlumno(@Valid @RequestBody Alumno alumno) {
        return alumnoRepo.save(alumno);
    }
	
	
	@DeleteMapping("/EliminarAlumno/{id}")
    public Map<String, Boolean> deleteAlumno(@PathVariable(value = "id") Integer alumnoId)
         throws ResourceNotFoundException {
        Alumno alumno = alumnoRepo.findById(alumnoId)
       .orElseThrow(() -> new ResourceNotFoundException("Alumnos not found for this id :: " + alumnoId));

        alumnoRepo.delete(alumno);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	}
	
	
	
	@PutMapping("/updateAlumno/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable(value = "id") Integer AlumnoId,
         @Valid @RequestBody Alumno alumnoDetails) throws ResourceNotFoundException {
		Alumno alumno = alumnoRepo.findById(AlumnoId)
        .orElseThrow(() -> new ResourceNotFoundException("alumno not found for this id :: " + AlumnoId));

        alumno.setNombre(alumnoDetails.getNombre());
        alumno.setDireccion(alumnoDetails.getDireccion());
        alumno.setEdad(alumnoDetails.getEdad());
        alumno.setTelefono(alumnoDetails.getTelefono());
        final Alumno updatedAlumno = alumnoRepo.save(alumno);
        return ResponseEntity.ok(updatedAlumno);
	}
	
	
	@GetMapping("/Alumno/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable(value = "id") Integer alumnoId)
        throws ResourceNotFoundException {
		Alumno alumno =  alumnoRepo.findById(alumnoId)
          .orElseThrow(() -> new ResourceNotFoundException("curso not found for this id :: " + alumnoId));
        return ResponseEntity.ok().body(alumno);
    }
	
    
}
