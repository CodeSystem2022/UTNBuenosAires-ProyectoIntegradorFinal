package com.proyecto_integrador.utnbuenosaires.model.dto;

import jakarta.validation.constraints.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioDto {
    @Size(min = 8, max = 8)
    @NotBlank
    private String dni;

    @Size(min = 11, max = 11)
    @NotBlank
    private String cuil;

    @Size(min = 2, max = 150)
    @NotBlank
    private String name;

    @Size(min = 2, max = 150)
    @NotBlank
    private String lastName;

    @Size(min = 6,max = 20)
    @NotBlank
    private String telephone;

    @Email
    @NotBlank
    private String email;

    @Size(min = 2,max = 150)
    @NotBlank
    private String neighborhood;

    @Size(min = 2,max = 150)
    @NotBlank
    private String province;

    @Size(min = 2,max = 150)
    @NotBlank
    private String country;

}