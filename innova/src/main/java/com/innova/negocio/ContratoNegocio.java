package com.innova.negocio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import com.innova.dto.EventDTO;
import com.innova.entidad.Contrato;

public interface ContratoNegocio {
	
	void guardar(Contrato contrato);
	void modificar(Contrato contrato);
	void eliminar(Long id);
	Contrato buscar(Long id);
	ArrayList<Contrato> buscarPorFecha(Date fecha);
	ArrayList<Contrato> listarContratos();
	ArrayList<Contrato> buscarContratoMes(Date fechaInicio, Date fechaFin);
	LinkedList<EventDTO> obtenerEventos() throws ParseException;

}
