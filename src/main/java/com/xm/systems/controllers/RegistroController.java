package com.xm.systems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xm.systems.dtos.RegistroDto;
import com.xm.systems.services.RegistroService;

@RestController
@RequestMapping(value = "/registros")
public class RegistroController {
	
	@Autowired
	private RegistroService registroService;
	
	@GetMapping("")
	public ResponseEntity<List<RegistroDto>> getAll(){
		return ResponseEntity.ok().body(registroService.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<RegistroDto> getById(@PathVariable("id") Long id){
		return ResponseEntity.ok().body(registroService.findById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<RegistroDto> save(@Validated @RequestBody RegistroDto registro){
		return ResponseEntity.ok().body(registroService.save(registro));
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<RegistroDto> update(@PathVariable("id") Long id, @RequestBody RegistroDto registro){
		return ResponseEntity.ok().body(registroService.update(id, registro));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		registroService.delete(id);
	}
	
}
