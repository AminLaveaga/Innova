package com.innova.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Actividad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column
	private String nombre;
	@Column
	private String hora;
	@Column
	private String informacion;
	public Actividad() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Actividad(Long id, String nombre, String hora, String informacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.hora = hora;
		this.informacion = informacion;
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
}

/*, Evento evento*/
//this.evento = evento;
/*
public Evento getEvento() {
	return evento;
}

public void setEvento(Evento evento) {
	this.evento = evento;
}
*/
//@ManyToOne
	//@JoinColumn(name="idEvento")
	//private Evento evento;