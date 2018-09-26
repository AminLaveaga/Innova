package com.innova.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.innova.dto.EventDTO;
import com.innova.entidad.Contrato;
import com.innova.negocio.ContratoNegocio;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@RestController
@RequestMapping(value="/contrato")
public class ContratoController {
	
	@Autowired
	ContratoNegocio contratoNegocio;
	//GUARDAR
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> guardar(@RequestBody Contrato contrato) {
		
		contratoNegocio.guardar(contrato);
		return new ResponseEntity(HttpStatus.ACCEPTED);
		
	}
	//MODIFICAR
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<?> modificar(@RequestBody Contrato contrato){
		contratoNegocio.modificar(contrato);
		 return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	//ELIMINAR
	@RequestMapping(method=RequestMethod.DELETE,value="/eliminar/id/{idContrato}") 
	public ResponseEntity<?> eliminar(@PathVariable Long idContrato){
		contratoNegocio.eliminar(idContrato);
		return new ResponseEntity(HttpStatus.ACCEPTED);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/id/{idContrato}")
	public ResponseEntity<?> buscar(@PathVariable Long idContrato) {
		
		Contrato c=contratoNegocio.buscar(idContrato);
		return new ResponseEntity(c,HttpStatus.ACCEPTED);
		
	}
	@RequestMapping(method=RequestMethod.GET, value="/fecha/{fecha}")
	public ArrayList<Contrato> contratosPorFecha(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date fecha){
		
		return contratoNegocio.buscarPorFecha(fecha);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/buscar"+ "")
	public ArrayList<Contrato> buscar(){
		
		return contratoNegocio.listarContratos();
		
	}
	@RequestMapping(method=RequestMethod.GET, value="/buscarProMes/fechaInicio/{fechaInicio}/fechaFin/{fechaFin}")
	public ArrayList<Contrato> buscarPorMes(@PathVariable @DateTimeFormat (pattern="yyyy-MM-dd")Date fechaInicio,@PathVariable @DateTimeFormat (pattern="yyyy-MM-dd") Date fechaFin){
		return contratoNegocio.buscarContratoMes(fechaInicio, fechaFin);
	};
	
	@RequestMapping(method=RequestMethod.GET, value="/obtenerEventos")
	public LinkedList<EventDTO> obtenerEventos() throws ParseException{
		
		return contratoNegocio.obtenerEventos();
		
	}
	

	@RequestMapping(method=RequestMethod.GET, value="/reporte/id/{idContrato}")
	@ResponseBody
	public Object reporteContrato(@PathVariable Long idContrato, HttpServletResponse response) throws IOException, JRException{
		System.out.println("LLego");
		Contrato c=contratoNegocio.buscar(idContrato);
		


        String sourceFile = "src/main/resources/reports/contratoReport.jasper";
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(Arrays.asList(c));
        Map parametros = new HashMap();
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition","attachment; filename=report.pdf");
        final  OutputStream outputStream = response.getOutputStream();
        JRPdfExporter jrPdfExporter = new JRPdfExporter();
        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFile,parametros,beanCollectionDataSource);
        jrPdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        jrPdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        jrPdfExporter.exportReport();
        return null;
	}
	
}
