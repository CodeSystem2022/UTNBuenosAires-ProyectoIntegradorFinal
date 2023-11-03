package com.proyecto_integrador.utnbuenosaires.model.dto;

import com.proyecto_integrador.utnbuenosaires.model.entity.Orden;
import com.proyecto_integrador.utnbuenosaires.model.entity.Producto;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetalleOrdenDto {

    @Size(min = 1, max = 20, message = "El nombre debe tener entre 1 y 20 caracteres")
    @NotBlank(message = "El campo 'nombre' no puede estar en blanco")
    private String nombre;

    @PositiveOrZero(message = "La cantidad debe ser un número positivo o cero")
    private double cantidad;

    @PositiveOrZero(message = "El precio debe ser un número positivo o cero")
    private double precio;

    @Positive(message = "El total debe ser un número positivo")
    private double total;

    // Agrega un campo para el número de orden
    @NotBlank(message = "El campo 'numeroDeOrden' no puede estar en blanco")
    private String numeroDeOrden;

}
