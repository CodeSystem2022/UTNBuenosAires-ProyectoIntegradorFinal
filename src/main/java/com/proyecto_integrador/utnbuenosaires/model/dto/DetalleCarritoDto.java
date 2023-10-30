package com.proyecto_integrador.utnbuenosaires.model.dto;

import com.proyecto_integrador.utnbuenosaires.model.entity.Carrito;
import com.proyecto_integrador.utnbuenosaires.model.entity.Producto;
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
    private Carrito carrito;

    @NotBlank
    private Producto producto;

}
