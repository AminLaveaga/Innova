package com.innova.negocio;

import java.util.ArrayList;

import com.innova.entidad.Cancion;


public interface CancionNegocio {
	void guardar(Cancion cancion);
	void modificar(Cancion cancion);
	void eliminar(Long id);
	Cancion buscarId(Long id);
	Cancion buscarPorNombre(String nombre);
	ArrayList<Cancion> buscarPorInterprete(String Interprete);
	ArrayList<Cancion> listarCanciones();

}
