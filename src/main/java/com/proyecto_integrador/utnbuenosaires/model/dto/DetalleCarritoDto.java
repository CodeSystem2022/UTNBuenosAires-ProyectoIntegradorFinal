package com.proyecto_integrador.utnbuenosaires.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetalleCarritoDto {

    private int cantidad;

    @NotBlank
    private CarritoDto carrito;

    @NotBlank
    private ProductoDto producto;

}
