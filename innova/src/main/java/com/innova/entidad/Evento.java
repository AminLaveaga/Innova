package com.innova.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@OneToMany(cascade=CascadeType.ALL , orphanRemoval=true)
	@JoinColumn(name="id_evento")
	private List<Actividad> actividades;
	@ManyToMany
	@JoinTable(name="contrato_cancion", joinColumns={@JoinColumn(name="idContrato")}, inverseJoinColumns={@JoinColumn(name="idCancion")})
	private List<Cancion> canciones;

	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(Long id, List<Actividad> actividades, List<Cancion> canciones/*, Contrato contrato*/) {
		super();
		this.id = id;
		this.actividades = actividades;
		this.canciones = canciones;
		//this.contrato = contrato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
}
/*@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="id_contrato")
@PrimaryKeyJoinColumn
private Contrato contrato;*/
/*
public Contrato getContrato() {
	return contrato;
}

public void setContrato(Contrato contrato) {
	this.contrato = contrato;
}

*/