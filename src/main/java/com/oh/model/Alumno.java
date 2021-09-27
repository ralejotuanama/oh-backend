package com.oh.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alumno")
public class Alumno {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;
	
	@Size(min = 8, max = 8, message = "DNI debe tener 8 caracteres")
	@Column(name = "dni", nullable = false, length = 8) // unique = true
	private String dni;
	
	
	
		public Integer getIdAlumno() {
		return idAlumno;
	}



	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public List<Nota> getListanotas() {
		return listanotas;
	}



	public void setListanotas(List<Nota> listanotas) {
		this.listanotas = listanotas;
	}



			@OneToMany(mappedBy = "alumno", cascade = { CascadeType.ALL }, orphanRemoval = true)
			private List<Nota> listanotas;
	
	
}
