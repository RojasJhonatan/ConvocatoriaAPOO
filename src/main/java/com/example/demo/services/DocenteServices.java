package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.DocenteModel;
import com.example.demo.models.response.ResponseModel;
import com.example.demo.repository.DocenteRepository;


@Service
public class DocenteServices {

	@Autowired
	DocenteRepository docenteRepository;
	
	public DocenteModel save(DocenteModel docenteModel) {
		return docenteRepository.save(docenteModel);
		}
	public List<DocenteModel> getAll(){
		return (List<DocenteModel>)docenteRepository.findAll();
	}
	
	public ResponseModel update(DocenteModel docenteModel) {
		try {
			if(!validacionDocente(docenteModel.getId())) {
				return new ResponseModel(false,"Docente no existe");
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
