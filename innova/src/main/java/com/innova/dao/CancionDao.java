package com.innova.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innova.entidad.Cancion;

public interface CancionDao extends JpaRepository<Cancion,Long> {
	
	Cancion findByNombre(String nombre);
	ArrayList<Cancion> findByInterprete(String interprete);

}
