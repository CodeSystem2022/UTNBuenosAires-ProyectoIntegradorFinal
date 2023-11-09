package com.proyecto_integrador.utnbuenosaires.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse {

	private String message;
	private boolean status;
}
