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

    @Size(min = 2, max = 100)
    @NotBlank
    private String nombre;

    @Size(min = 2, max = 150)
    @NotBlank
    private String descripcion;

    @Size(min = 2, max = 150)
    @NotBlank
    private String imagen;

    @Size(min = 6,max = 20)
    @NotBlank
    private double precio;

    @Email
    @NotBlank
    private int cantidad;

    @Size(min = 2,max = 150)
    @NotBlank
    private Usuario usuario;

}