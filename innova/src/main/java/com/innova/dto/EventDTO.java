package com.innova.dto;

import java.util.Date;

public class EventDTO {
	private  long  id;
	private String title;
	private String description;
	private String start;
	private boolean allDay;
	private boolean stick;
	private long cantidad;
	
	public EventDTO() {
		super();
	}

	public EventDTO(long id, String title, String description, String start, boolean allDay, boolean stick,
			long cantidad) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.start = start;
		this.allDay = allDay;
		this.stick = stick;
		this.cantidad = cantidad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public boolean isStick() {
		return stick;
	}

	public void setStick(boolean stick) {
		this.stick = stick;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
