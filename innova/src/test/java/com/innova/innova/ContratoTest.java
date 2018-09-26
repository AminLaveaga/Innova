//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = InnovaApplication.class)
//----@ContextConfiguration(classes = InnovaApplication.class)
//@WebAppConfiguration


package com.innova.innova;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.innova.InnovaApplication;
import com.innova.entidad.Contrato;
import com.innova.negocio.ContratoNegocio;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InnovaApplication.class, webEnvironment = 
SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContratoTest {
	
	 @Autowired
	 ContratoNegocio contratoService;
	 
	 Contrato contrato =  null;
	    @Before
	    public void init(){
	    	contrato =  new Contrato();
	    	contrato.setLugar("Jardin de eventos");
	    	contrato.setFechaContratacion(new Date());
	    	contrato.setDuracionEvento(5);
	    	contrato.setCantidadTotal("500");
	    	contrato.setCantidadTotalTexto("Quinientos Pesos");
	    	contrato.setFechaEvento(new Date());
	    	contrato.setFestejados("Festejados");
	    	contrato.setHoraInicio("21:00");
	    }
	    	    
	    @Test
	    public void A_Guardar() {
	     contratoService.guardar(contrato);
	     Assert.assertTrue(contrato.getId() != 0);
	    }	    
	    
	    @Test
	    public void B_buscarContratoExistente() {
		contratoService.guardar(contrato);
	    Contrato resultado =  contratoService.buscar(contrato.getId());
	        Assert.assertTrue(resultado != null);
	    }
   
	    @Test
	    public void C_buscarContratoNoExistente() {
	    Contrato resultado =  contratoService.buscar(3000L);
	        Assert.assertFalse(resultado != null);
	    }

	    @Test
	    public void D_ObtenerContratos() {
	    ArrayList<Contrato> resultado =  contratoService.listarContratos();
	        Assert.assertTrue(resultado.size() > 0);
	    }
	    
	    @Test(expected = NullPointerException.class)
	    public void E_guardar_objeto_vacio() {
	    	
	    	Contrato c =  null;
	    	c.getId();
	    }
	    
	    @Test
	    public void F_Eliminar() {
		    contratoService.guardar(contrato);
	    	contratoService.eliminar(contrato.getId());
	    	Contrato c =  contratoService.buscar(contrato.getId());
	    	 Assert.assertTrue(c == null);
	    }

}
