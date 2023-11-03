package com.proyecto_integrador.utnbuenosaires.model.dto;

import com.proyecto_integrador.utnbuenosaires.model.entity.Usuario;
import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductoDto {

    @Size(min = 2, max = 100, message = "El campo 'nombre' debe tener entre 2 y 100 caracteres")
    @NotBlank(message = "El campo 'nombre' no puede estar vacío")
    private String nombre;

    @Size(min = 2, max = 150, message = "El campo 'descripcion' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'descripcion' no puede estar vacío")
    private String descripcion;

    @Size(min = 2, max = 150, message = "El campo 'imagen' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'imagen' no puede estar vacío")
    private String imagen;

    @Min(value = 0, message = "El campo 'precio' debe ser mayor o igual a 0")
    @Max(value = 99999, message = "El campo 'precio' debe ser menor o igual a 99999")
    private double precio;

    @Min(value = 0, message = "El campo 'cantidad' debe ser mayor o igual a 0")
    private int cantidad;


}