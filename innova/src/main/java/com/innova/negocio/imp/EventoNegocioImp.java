package com.innova.negocio.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.EventoDao;
import com.innova.entidad.Evento;
import com.innova.negocio.EventoNegocio;

@Service
public class EventoNegocioImp implements EventoNegocio{
	
	@Autowired
	EventoDao eventoDao;
	@Override
	public void guardar(Evento evento) {
		
		eventoDao.save(evento);
		
	}

	@Override
	public void modificar(Evento evento) {
		eventoDao.save(evento);
		
	}

	@Override
	public void eliminar(Long id) {
		eventoDao.delete(id);
		
	}

	@Override
	public Evento buscar(Long id) {
		
		return eventoDao.findOne(id);
	}

	@Override
	public ArrayList<Evento> listarEventos() {
		
		return (ArrayList<Evento>) eventoDao.findAll();
	}

	@Override
	public Evento buscarIdContrato(Long id) {
		// TODO Auto-generated method stub
		//return eventoDao.findByContrato(id);
		return null;
	}

}
