package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import com.example.demo.models.DocenteModel;
import com.example.demo.models.response.ResponseModel;
import com.example.demo.repository.DocenteRepository;


@Service
public class DocenteServices {

	@Autowired
	DocenteRepository docenteRepository;
	
	public ResponseModel save(DocenteModel docenteModel) {
	    try {
	        // Validar si el número de documento ya existe
	        if (docenteRepository.existsByNumeroDocumento(docenteModel.getNumeroDocumento())) {
	            return new ResponseModel(false, "El número de documento ya existe");
	        }

	        docenteRepository.save(docenteModel);
	        return new ResponseModel(true, "Docente registrado");

	    } catch (DataIntegrityViolationException e) {
	        
	        return new ResponseModel(false, e.getMessage());
	    }
	
	}
	public List<DocenteModel> getAll(){
		return (List<DocenteModel>)docenteRepository.findAll();
	}
	
	public ResponseModel update(DocenteModel docenteModel) {
		try {
			if(!validacionDocente(docenteModel.getId())) {
				return new ResponseModel(false,"Docente no existe");
			}
			//Validación si el numero de documento único cambió 
			DocenteModel existente = docenteRepository.findById(docenteModel.getId()).orElse(null);

		        if (!existente.getNumeroDocumento().equals(docenteModel.getNumeroDocumento()) &&
		            docenteRepository.existsByNumeroDocumento(docenteModel.getNumeroDocumento())) {

		            return new ResponseModel(false, "El número de documento ya existe");		      		
		}else {
				//Actualización de docente
				docenteRepository.save(docenteModel);
				return new ResponseModel(true,"Docente actualizado");
			}	
		}catch(Exception e){
			return new ResponseModel(false,e.getMessage());
		}
	}
	
	
	
	public ResponseModel deleteDocente(int id) {
		try {
			if(!validacionDocente(id)) {
				return new ResponseModel(false,"Docente no existe");
			}else {
				docenteRepository.deleteById(id);
				return new ResponseModel(true,"Docente eliminado");
			}
			
		
		}catch(Exception e) {
			return new ResponseModel(false,e.getMessage());
		}
}
	
	private boolean validacionDocente(int id) {
		return docenteRepository.findById(id).isEmpty() ? false : true;
		
	}
	
	
}
