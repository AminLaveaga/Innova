package com.innova.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table
public class Cancion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String nombre;
	@Column
	private String interprete;
	@Column
	private String genero;

	public Cancion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cancion(Long id, String nombre, String interprete, String genero/*, Evento evento*/) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.interprete = interprete;
		this.genero = genero;
		//this.evento = evento;
	}

	public Long getId() {
		return this.id;
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

	public String getInterprete() {
		return interprete;
	}

	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
/*@ManyToOne
@JoinColumn(name="idEvento")
private Evento evento;*/

/*
	public Evento getEvento() {
		return evento;
	}





	public void setEvento(Evento evento) {
		this.evento = evento;
	}

*/
