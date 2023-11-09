package com.proyecto_integrador.utnbuenosaires.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
	
	private Long cartItemId;
	private CartDTO cart;
	private ProductoDto product;
	private Integer quantity;
	private double discount;
	private double productPrice;
}
