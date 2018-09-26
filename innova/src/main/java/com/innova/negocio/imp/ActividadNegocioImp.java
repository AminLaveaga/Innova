package com.innova.negocio.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.ActividadDao;
import com.innova.entidad.Actividad;
import com.innova.negocio.ActividadNegocio;
@Service
public class ActividadNegocioImp implements ActividadNegocio {
	@Autowired
	ActividadDao actividadDao;

	@Override
	public void guardar(Actividad actividad) {
		actividadDao.save(actividad);
	}

	@Override
	public void modificar(Actividad actividad) {
		actividadDao.save(actividad);

	}

	@Override
	public void Eliminar(Long id) {
		actividadDao.delete(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actividad buscar(Long id) {
		
		// TODO Auto-generated method stub
		return actividadDao.findOne(id);
	}

	@Override
	public ArrayList<Actividad> listarActividades() {
		
		// TODO Auto-generated method stub
		return (ArrayList<Actividad>) actividadDao.findAll();
	}

}
