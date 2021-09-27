package com.oh.service;


import com.oh.model.Alumno;


public interface IAlumnoService extends ICRUD<Alumno, Integer>{

	Alumno RegistrarCompuesto(Alumno alu) throws Exception;
}
