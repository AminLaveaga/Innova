package com.innova.controller.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/saludo")
public class InnovaHelloController {
	
	
	@RequestMapping(value="/hola")
	public String hello() {
		return "Holla Innova";
	};

}
