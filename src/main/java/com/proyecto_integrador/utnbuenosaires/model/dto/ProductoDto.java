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

    @Size(min = 6, max = 20, message = "El campo 'precio' debe tener entre 6 y 20 caracteres")
    @NotBlank(message = "El campo 'precio' no puede estar vacío")
    private double precio;

    @Email(message = "El campo 'cantidad' debe ser un correo electrónico válido")
    @NotBlank(message = "El campo 'cantidad' no puede estar vacío")
    private int cantidad;

    @Size(min = 2, max = 150, message = "El campo 'usuario' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'usuario' no puede estar vacío")
    private Usuario usuario;

}