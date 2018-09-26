package com.innova.negocio.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.ContratoDao;
import com.innova.dto.EventDTO;
import com.innova.entidad.Contrato;
import com.innova.negocio.ContratoNegocio;

@Service
public class ContratoNegocioImp implements ContratoNegocio{
	
@Autowired	
ContratoDao contratoDao;

@Override
public void guardar(Contrato contrato) {
	
	contratoDao.save(contrato);
	// TODO Auto-generated method stub
	
}

@Override
public void modificar(Contrato contrato) {
	contratoDao.save(contrato);
	// TODO Auto-generated method stub
	
}

@Override
public void eliminar(Long id) {
	contratoDao.delete(id);
}

@Override
public Contrato buscar(Long id) {	
	return contratoDao.findOne(id);
}

@Override
public ArrayList<Contrato> buscarPorFecha(Date fecha) {
	
	// TODO Auto-generated method stub
	return contratoDao.findByFechaContratacion(fecha);
}

@Override
public ArrayList<Contrato> listarContratos() {
	// TODO Auto-generated method stub
	return (ArrayList<Contrato>) contratoDao.findAll();
}

@Override
public ArrayList<Contrato> buscarContratoMes(Date fechaInicio, Date fechaFin) {
	return contratoDao.findByFechaEventoBetween(fechaInicio, fechaFin);
	// TODO Auto-generated method stub

}

@Override
public LinkedList<EventDTO> obtenerEventos() throws ParseException {
	ArrayList<Contrato> contratos =(ArrayList<Contrato>) contratoDao.findAll();
	LinkedList<EventDTO> eventos =  new LinkedList<EventDTO>();
	for (Contrato c : contratos){
			EventDTO e = new EventDTO();
	        System.out.println("asdf : "+ c.getHoraInicio());
			e.setId(c.getId());
			e.setTitle(c.getTipoEvento() + " en " + c.getLugar() );
	      //  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm a");
	        String dateInString = c.getFechaEvento().toString().trim() +" " + c.getHoraInicio().trim();
			e.setStart(dateInString);
			//formatter.applyPattern("yyyy-MM-dd HH:mm a");
			e.setAllDay(false);
			e.setStick(true);
			e.setCantidad(c.getDuracionEvento());
			eventos.add(e);
	}
	
	// TODO Auto-generated method stub
	return eventos;
}	

}
