package com.innova.negocio;

import java.util.ArrayList;

import com.innova.entidad.Evento;

public interface EventoNegocio {
	
	void guardar(Evento evento);
	void modificar(Evento evento);
	void eliminar(Long id);
	Evento buscar(Long id);
	ArrayList<Evento> listarEventos();
	Evento buscarIdContrato(Long id);
}
