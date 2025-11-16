package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="docente")

	
public class DocenteModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false, unique =true)
	private int id;
	@Column(nullable=false, unique =true)
	private String numeroDocumento;
	@Column(nullable=false)
	private int tipoDocumentoId;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String lastname;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String phone;
	
	//get & set
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public int getTipoDocumentoId() {
		return tipoDocumentoId;
	}
	public void setTipoDocumentoId(int tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
		
	
	
}
