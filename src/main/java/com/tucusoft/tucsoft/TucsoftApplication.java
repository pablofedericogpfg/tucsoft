package com.tucusoft.tucsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.tucusoft.tucsoft.model.Producto;
import com.tucusoft.tucsoft.model.Usuario;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication() //exclude = DataSourceAutoConfiguration.class)
@Slf4j
public class TucsoftApplication {

	public static void main(String[] args) {
		//System.out.println(Usuario.builder().id(1).nombre("Pablo"));
		log.info(Usuario.builder().id(1).nombre("Pablo").toString());
		log.info(Producto.builder().id(1).nombre("Nombre").toString());
		
		SpringApplication.run(TucsoftApplication.class, args);
	}

}
