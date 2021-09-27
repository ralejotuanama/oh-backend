package com.oh.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.oh.exception.ModeloNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oh.model.Alumno;

import com.oh.service.IAlumnoService;


@RestController
@RequestMapping("/alumnos")

public class AlumnoController {

	@Autowired	
	private IAlumnoService service;
	
	@GetMapping
	public ResponseEntity<List<Alumno>> listar() throws Exception{
		List<Alumno> lista = service.listar();
		return new ResponseEntity<List<Alumno>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Alumno obj = service.listarPorId(id);
		if(obj == null ) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Alumno>(obj, HttpStatus.OK);
	}

	
	@GetMapping("/hateoas/{id}")
	public EntityModel<Alumno> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
		Alumno obj = service.listarPorId(id);
		if(obj == null ) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		//localhost:8080/alumnos/{id}
		EntityModel<Alumno> recurso = EntityModel.of(obj); 
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		recurso.add(linkTo.withRel("alumno-recurso"));
		
		return recurso;
	}
		
	
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Alumno alumno) throws Exception{
		Alumno obj = service.RegistrarCompuesto(alumno);
		
		//localhost:8080/alumnos/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getIdAlumno()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Alumno> modificar(@Valid @RequestBody Alumno alumno) throws Exception{
		Alumno obj = service.modificar(alumno);
		return new ResponseEntity<Alumno>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Alumno obj = service.listarPorId(id);
		if(obj.getIdAlumno() == null ) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

}
