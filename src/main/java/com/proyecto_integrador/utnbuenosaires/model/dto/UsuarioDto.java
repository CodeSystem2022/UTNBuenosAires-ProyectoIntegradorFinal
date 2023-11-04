package com.proyecto_integrador.utnbuenosaires.model.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioDto {

    @Size(min = 8, max = 8, message = "El campo 'dni' debe tener exactamente 8 caracteres")
    @NotBlank(message = "El campo 'dni' no puede estar vacío")
    private String dni;

    @Size(min = 11, max = 11, message = "El campo 'cuil' debe tener exactamente 11 caracteres")
    @NotBlank(message = "El campo 'cuil' no puede estar vacío")
    private String cuil;

    @Size(min = 2, max = 150, message = "El campo 'name' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'name' no puede estar vacío")
    private String name;

    @Size(min = 2, max = 150, message = "El campo 'lastName' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'lastName' no puede estar vacío")
    private String lastName;

    @Size(min = 6, max = 20, message = "El campo 'telephone' debe tener entre 6 y 20 caracteres")
    @NotBlank(message = "El campo 'telephone' no puede estar vacío")
    private String telephone;

    @Email(message = "El campo 'email' debe ser una dirección de correo electrónico válida")
    @NotBlank(message = "El campo 'email' no puede estar vacío")
    private String email;

    @Size(min = 2, max = 150, message = "El campo 'neighborhood' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'neighborhood' no puede estar vacío")
    private String neighborhood;

    @Size(min = 2, max = 150, message = "El campo 'province' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'province' no puede estar vacío")
    private String province;

    @Size(min = 2, max = 150, message = "El campo 'country' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'country' no puede estar vacío")
    private String country;

    @Size(min = 2, max = 150, message = "El campo 'nameUser' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'nameUser' no puede estar vacío")
    private String nameUser;

    @Size(min = 2, max = 150, message = "El campo 'password' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'password' no puede estar vacío")
    private String password;
}
