package com.proyecto_integrador.utnbuenosaires.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

	private Long orderItemId;
	private ProductoDto product;
	private Integer quantity;
	private double discount;
	private double orderedProductPrice;
}
