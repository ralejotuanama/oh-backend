package com.oh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "nota")
public class Nota {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNota;
	
	
	public Integer getIdNota() {
		return idNota;
	}


	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}





	public Double getPractica1() {
		return practica1;
	}


	public void setPractica1(Double practica1) {
		this.practica1 = practica1;
	}


	public Double getPractica2() {
		return practica2;
	}


	public void setPractica2(Double practica2) {
		this.practica2 = practica2;
	}


	public Double getPractica3() {
		return practica3;
	}


	public void setPractica3(Double practica3) {
		this.practica3 = practica3;
	}


	public Double getPractica4() {
		return practica4;
	}


	public void setPractica4(Double practica4) {
		this.practica4 = practica4;
	}




	public Double getExamenfinal() {
		return examenfinal;
	}


	public void setExamenfinal(Double examenfinal) {
		this.examenfinal = examenfinal;
	}


	public Alumno getAlumno() {
		return alumno;
	}


	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_alumno", nullable = false, foreignKey = @ForeignKey(name = "FK_alumno_nota"))
	private Alumno alumno;
	
	@Column(name = "practica1",nullable = false)
	private Double practica1;
	
	@Column(name = "practica2",nullable = false)
	private Double practica2;
	
	@Column(name = "practica3",nullable = false)
	private Double practica3;
	
	@Column(name = "practica4",nullable = false)
	private Double practica4;
	
	@Column(name = "examenparcial",nullable = false)
	private Double examenparcial;
	
	
	public Double getExamenparcial() {
		return examenparcial;
	}


	public void setExamenparcial(Double examenparcial) {
		this.examenparcial = examenparcial;
	}


	@Column(name = "examenfinal",nullable = false)
	private Double examenfinal;
	
	

}
