package com.example.demo.controllers;

import java.util.List;

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

import com.example.demo.models.DocenteModel;
import com.example.demo.models.response.ResponseModel;
import com.example.demo.services.DocenteServices;

@RestController
@RequestMapping("/docente")

public class DocenteController {
	@Autowired
	DocenteServices docenteServices;
	
	@GetMapping
	public ResponseEntity<List<DocenteModel>> getAll(){
		return ResponseEntity.ok(docenteServices.getAll());
		}
	
	@PostMapping
	public ResponseEntity<ResponseModel> save( @RequestBody DocenteModel docenteModel){
		return ResponseEntity.ok(docenteServices.save(docenteModel));
	}
	
	@PutMapping
	public ResponseEntity<ResponseModel> update(@RequestBody DocenteModel docenteModel){
		return ResponseEntity.ok(docenteServices.update(docenteModel));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseModel> delete(@PathVariable("id") int id){
		return ResponseEntity.ok(docenteServices.deleteDocente(id));
		}	

}
