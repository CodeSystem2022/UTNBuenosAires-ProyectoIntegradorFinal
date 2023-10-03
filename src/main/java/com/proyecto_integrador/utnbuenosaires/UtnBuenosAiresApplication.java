package com.proyecto_integrador.utnbuenosaires;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class) // con esto no tendrá en cuenta la BD
public class UtnBuenosAiresApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtnBuenosAiresApplication.class, args);
	}

}
