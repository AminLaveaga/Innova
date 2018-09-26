package com.innova.negocio;

import java.util.ArrayList;

import com.innova.entidad.Actividad;

public interface ActividadNegocio {
	
	void guardar(Actividad actividad);
	void modificar(Actividad actividad);
	void Eliminar(Long id);
	Actividad buscar(Long id);
	ArrayList<Actividad> listarActividades();

}
