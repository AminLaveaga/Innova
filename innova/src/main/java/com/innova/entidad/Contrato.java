package com.innova.entidad;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table
public class Contrato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column
	private String nombreCliente;
	@Column
	private String telefonoCliente;
	@Column
	private String tipoEvento;
	@Column
	private String festejados;
	@Temporal(TemporalType.DATE)
	@Column
	private Date fechaEvento;
	@Column
	private String lugar;
	@Column
	private String horaInicio;
	@Column
	private int duracionEvento;
	@Column
	private String cantidadTotal;
	@Column
	private String cantidadTotalTexto;
	@Column
	private String enganche;
	@Column
	private String resto;
	@Temporal(TemporalType.DATE)
	@Column
	private Date fechaContratacion;
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Evento evento;
	
	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contrato(Long id, String nombreCliente, String telefonoCliente, String tipoEvento, String festejados,
			Date fechaEvento, String lugar, String horaInicio, int duracionEvento, String cantidadTotal,
			String cantidadTotalTexto, String enganche, String resto, Date fechaContratacion, Evento evento) {
		super();
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.telefonoCliente = telefonoCliente;
		this.tipoEvento = tipoEvento;
		this.festejados = festejados;
		this.fechaEvento = fechaEvento;
		this.lugar = lugar;
		this.horaInicio = horaInicio;
		this.duracionEvento = duracionEvento;
		this.cantidadTotal = cantidadTotal;
		this.cantidadTotalTexto = cantidadTotalTexto;
		this.enganche = enganche;
		this.resto = resto;
		this.fechaContratacion = fechaContratacion;
		this.evento = evento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getFestejados() {
		return festejados;
	}

	public void setFestejados(String festejados) {
		this.festejados = festejados;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getDuracionEvento() {
		return duracionEvento;
	}

	public void setDuracionEvento(int duracionEvento) {
		this.duracionEvento = duracionEvento;
	}

	public String getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(String cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public String getCantidadTotalTexto() {
		return cantidadTotalTexto;
	}

	public void setCantidadTotalTexto(String cantidadTotalTexto) {
		this.cantidadTotalTexto = cantidadTotalTexto;
	}

	public String getEnganche() {
		return enganche;
	}

	public void setEnganche(String enganche) {
		this.enganche = enganche;
	}

	public String getResto() {
		return resto;
	}

	public void setResto(String resto) {
		this.resto = resto;
	}

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	
	
}
