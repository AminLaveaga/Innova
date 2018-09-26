package com.innova.negocio.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.CancionDao;
import com.innova.entidad.Cancion;
import com.innova.entidad.Contrato;
import com.innova.negocio.CancionNegocio;

@Service
public class CancionNegocioImp implements CancionNegocio{
	@Autowired
	CancionDao cancionDao;
	
	@Override
	public void guardar(Cancion cancion) {
		
		cancionDao.save(cancion);
		
	}

	@Override
	public void modificar(Cancion cancion) {
		
		cancionDao.save(cancion);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		cancionDao.delete(id);
		
	}

	@Override
	public Cancion buscarId(Long id) {
		// TODO Auto-generated method stub
		return cancionDao.findOne(id);
	}

	@Override
	public Cancion buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return cancionDao.findByNombre(nombre);
	}

	@Override
	public ArrayList<Cancion> buscarPorInterprete(String interprete) {
		// TODO Auto-generated method stub
		return cancionDao.findByInterprete(interprete);
	}

	@Override
	public ArrayList<Cancion> listarCanciones() {
		// TODO Auto-generated method stub
		return (ArrayList<Cancion>) cancionDao.findAll();
	}


}
