package com.proyecto_integrador.utnbuenosaires.model.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioDto {

    @Size(min = 2, max = 150)
    @NotBlank
    private String username;

    @Size(min = 2, max = 150)
    @NotBlank
    private String password;

    @Size(min = 2, max = 150)
    @NotBlank
    private String nombre;

    @Size(min = 2, max = 150)
    @NotBlank
    private String apellido;

    @Size(min = 2, max = 150)
    @NotBlank
    private String email;

    @Size(min = 2, max = 150)
    @NotBlank
    private String direccion;

    @Size(min = 2, max = 150)
    @NotBlank
    private String telefono;

    @Size(min = 2, max = 150)
    @NotBlank
    private String rol;
}