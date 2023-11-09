package com.proyecto_integrador.utnbuenosaires.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
	
	private Long cartId;
	private Double totalPrice = 0.0;
	private List<ProductoDto> products = new ArrayList<>();
}
