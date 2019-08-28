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
import com.Schoolv.Schoolv.model.Expediente;
import com.Schoolv.Schoolv.repository.ExpedienteRepo;




@RestController
@RequestMapping("/api")
public class ExpedienteController {

	@Autowired
    private ExpedienteRepo expedienteRepo;

	@PutMapping("/updateExpediente/{id}")
    public ResponseEntity<Expediente> updateProfesor(@PathVariable(value = "id") Integer expedienteId,
         @Valid @RequestBody Expediente expedienteDetails) throws ResourceNotFoundException {
		Expediente expediente = expedienteRepo.findById(expedienteId)
        .orElseThrow(() -> new ResourceNotFoundException("expediente not found for this id :: " + expedienteId));

        expediente.setIdAlumno(expedienteDetails.getIdAlumno());
        expediente.setCarrera(expedienteDetails.getCarrera());
        expediente.setTipoSangre(expedienteDetails.getTipoSangre());

        
        final Expediente updatedExpediente = expedienteRepo.save(expediente);
        return ResponseEntity.ok(updatedExpediente);
    }
	
}
