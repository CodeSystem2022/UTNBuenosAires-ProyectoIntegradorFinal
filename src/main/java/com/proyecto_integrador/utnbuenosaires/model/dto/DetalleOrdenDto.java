package com.proyecto_integrador.utnbuenosaires.model.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetalleOrdenDto {
    @NotNull
    private Long id_producto; // Cambio el tipo a Long para almacenar el ID del producto.

    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    @NotBlank(message = "El campo 'nombre' no puede estar en blanco")
    private String nombre;

    @PositiveOrZero(message = "La cantidad debe ser un número positivo o cero")
    private double cantidad;

    @PositiveOrZero(message = "El precio debe ser un número positivo o cero")
    private double precio;

    // Agrega un campo para el número de orden
    @NotBlank(message = "El campo 'numeroDeOrden' no puede estar en blanco")
    private String numeroDeOrden;
}
