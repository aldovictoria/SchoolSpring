package com.Schoolv.Schoolv.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Schoolv.Schoolv.exception.ResourceNotFoundException;
import com.Schoolv.Schoolv.model.Curso;
import com.Schoolv.Schoolv.model.Profesor;
import com.Schoolv.Schoolv.repository.CursoRepo;

@RestController
@RequestMapping("/api")
public class CursoController {
	@Autowired
	private CursoRepo cursoRepo;
	
	@PostMapping("/setCurso")
    public Curso createCurso(@Valid @RequestBody Curso curso) {
        return cursoRepo.save(curso);
    }
	
	
	@PutMapping("/updateCurso/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable(value = "id") Integer cursoId,
         @Valid @RequestBody Curso cursoDetails) throws ResourceNotFoundException {
		Curso curso = cursoRepo.findById(cursoId)
        .orElseThrow(() -> new ResourceNotFoundException("curso not found for this id :: " + cursoId));

   
        curso.setNombreCurso(cursoDetails.getNombreCurso());
        final Curso updatedCurso = cursoRepo.save(curso);
        return ResponseEntity.ok(updatedCurso);
	}
	
	
	@GetMapping("/Curso/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable(value = "id") Integer cursoId)
        throws ResourceNotFoundException {
		Curso curso =  cursoRepo.findById(cursoId)
          .orElseThrow(() -> new ResourceNotFoundException("curso not found for this id :: " + cursoId));
        return ResponseEntity.ok().body(curso);
    }
	

}
