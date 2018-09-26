package com.innova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.innova.seguridad.JwtFilter;


/* QUITAR LA EXTENCION DE  SpringBootServletInitializer*/
@SpringBootApplication
public class InnovaApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/secure/*"/*,"/contrato/*"*/);

		return registrationBean;
	}
	
 /* cORRER CON PIVOTAL*/
	public static void main(String[] args) {
		SpringApplication.run(InnovaApplication.class, args);
	}
	 
}
