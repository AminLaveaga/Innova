package com.innova.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innova.entidad.Evento;
import com.innova.negocio.EventoNegocio;

@RestController
@RequestMapping(value="/evento")
public class EventoController {
	
	@Autowired
	EventoNegocio eventoNegocio;
	
	//GUARDAR
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<?> guardar(@RequestBody  Evento evento){
		
		eventoNegocio.modificar(evento);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> modificar(@RequestBody  Evento evento){
		eventoNegocio.guardar(evento);

			 return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/eliminar/idEvento/{idEvento}")
	public ResponseEntity<?> eliminar(@PathVariable Long idEvento){
		eventoNegocio.eliminar(idEvento);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/buscar/idEvento/{idEvento}")
	public ResponseEntity<?> buscar(@PathVariable Long idEvento){
		
		Evento e=eventoNegocio.buscar(idEvento);
		return new ResponseEntity(e,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/listar")
	public ArrayList<Evento> listarEventos(){
		
		return eventoNegocio.listarEventos();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/buscar/idcontrato/{idcontrato}")
	public ResponseEntity<?> buscarIdContrato(@PathVariable Long idcontrato){
		
		Evento e=eventoNegocio.buscarIdContrato(idcontrato);
		return new ResponseEntity(e,HttpStatus.ACCEPTED);
	}
	

}
