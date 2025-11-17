package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DocenteModel;

@Repository
public interface DocenteRepository extends CrudRepository<DocenteModel,Integer>{
	
	//consultas personalizadas
	public boolean existsByNumeroDocumento(String documentNumber);

}
