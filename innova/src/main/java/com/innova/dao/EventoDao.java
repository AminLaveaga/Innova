package com.innova.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innova.entidad.Evento;


public interface EventoDao extends JpaRepository<Evento,Long> {
	

}
