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

import com.innova.entidad.Cancion;
import com.innova.negocio.CancionNegocio;

@RestController
@RequestMapping(value="/cancion")
public class CancionController {
	@Autowired
	CancionNegocio cancionNegocio;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> guardar(@RequestBody Cancion cancion){
		
		cancionNegocio.guardar(cancion);
		
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<?> modificar(@RequestBody Cancion cancion){
		cancionNegocio.modificar(cancion);
		 return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/eliminar/idcancion/{idcancion}")
	public ResponseEntity<?> eliminar(@PathVariable Long idcancion){
		cancionNegocio.eliminar(idcancion);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	

	@RequestMapping(method=RequestMethod.GET,value="/buscar/idcancion/{idcancion}")
	public ResponseEntity<?> buscarId(@PathVariable Long idcancion){
		Cancion c=cancionNegocio.buscarId(idcancion);
		return new ResponseEntity(c,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/buscar/nombrecancion/{nombrecancion}")
	public ResponseEntity<?> buscarPorNombre(@PathVariable String nombrecancion){
		Cancion c=cancionNegocio.buscarPorNombre(nombrecancion);
		return new ResponseEntity(c,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/buscar/interpretecancion/{interprete}")
	public ArrayList<Cancion> buscarPorInterprete(@PathVariable String interprete){
		
		return cancionNegocio.buscarPorInterprete(interprete);
		
	}
	

	@RequestMapping(method=RequestMethod.GET, value="/buscar")
	public ArrayList<Cancion> listarCanciones(){
		
		return cancionNegocio.listarCanciones();
		
	}
	
	
}
