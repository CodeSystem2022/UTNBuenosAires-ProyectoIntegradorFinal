package com.proyecto_integrador.utnbuenosaires.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    /**
     * Modelado de estructura para Registro de usuarios
     */
    String username;
    String password;
    String direccion;
    String nombre;
    String apellido;
    String email;
    String telefono;

}
