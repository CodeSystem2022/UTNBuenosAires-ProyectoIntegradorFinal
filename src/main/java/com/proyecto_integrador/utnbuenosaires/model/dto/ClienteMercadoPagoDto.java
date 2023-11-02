package com.proyecto_integrador.utnbuenosaires.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class ClienteMercadoPagoDto {
    @NotBlank(message = "El campo 'idCliente' no puede estar vacío")
    private String idCliente;

    @Size(min = 2, max = 150, message = "El campo 'nombre' debe tener entre 2 y 150 caracteres")
    @NotBlank(message = "El campo 'nombre' no puede estar vacío")
    private String nombre;

    @Email(message = "El campo 'email' debe ser una dirección de correo electrónico válida")
    @NotBlank(message = "El campo 'email' no puede estar vacío")
    private String email;

}
