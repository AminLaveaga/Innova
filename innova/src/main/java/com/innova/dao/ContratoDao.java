package com.innova.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innova.entidad.Contrato;


public interface ContratoDao extends JpaRepository<Contrato,Long>{


	ArrayList<Contrato> findByFechaContratacion(Date fechaContratacion);
	ArrayList<Contrato> findByFechaEventoBetween(Date fechaInicio,Date fechaFin);
	
	
}
