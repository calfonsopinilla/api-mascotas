package com.mascotas.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Mascota {
	@Id
	private String id;
	
	@Column
	private String nombre;
	
	@Column
	private String raza;
	
	@Column
	private Integer edad;
	
	@CreationTimestamp
	@Column(name="registro", nullable = false, updatable = false)
	private Timestamp registro;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Timestamp getRegistro() {
		return registro;
	}

	public void setRegistro(Timestamp registro) {
		this.registro = registro;
	}

}
