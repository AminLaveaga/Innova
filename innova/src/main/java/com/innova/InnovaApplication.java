package com.innova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/* QUITAR LA EXTENCION DE  SpringBootServletInitializer*/
@SpringBootApplication
public class InnovaApplication  extends SpringBootServletInitializer{
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(InnovaApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InnovaApplication.class, args);
    }
	
/*
 * cORRER CON PIVOTAL
	public static void main(String[] args) {
		SpringApplication.run(InnovaApplication.class, args);
	}
	*/
}
